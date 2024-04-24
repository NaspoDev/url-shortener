package dev.naspo.urlshortenerserver;

import dev.naspo.urlshortenerserver.database.DatabaseService;
import static dev.naspo.urlshortenerserver.database.generated.Tables.*;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

// Handles requests to "/urls"
@RestController
@RequestMapping("/urls")
public class URLController {

    private DatabaseService databaseService;
    private DSLContext db;

    public URLController(@Autowired DatabaseService databaseService) {
        this.databaseService = databaseService;
        this.db = databaseService.getDslContext();
    }

    // Get original url from token
    @GetMapping("/{token}")
    public String getOriginalURL(@PathVariable("token") String token) {
        Record1<String> result = db.select(URLS.ORIGINAL_URL)
                .from(URLS).where(URLS.TOKEN.eq(token)).fetchOne();

        if (result != null) {
            return result.get(URLS.ORIGINAL_URL);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new shortened url
    @PostMapping("")
    public URL createShortenedURL(@RequestBody String originalURL) {
        // Create new record in DB
        db.insertInto(URLS, URLS.ORIGINAL_URL)
                .values(originalURL)
                .execute();

        // Get the database id now that it has been inserted.
        Result<Record1<Integer>> databaseIdResult = db.select(URLS.ID)
                .from(URLS)
                .where(URLS.ORIGINAL_URL.eq(originalURL))
                .fetch();

        // set the database id and create the URL object
        int databaseId = databaseIdResult.getLast().value1();
        URL url = new URL(originalURL, databaseId);

        // update the url record in the database with the token
        db.update(URLS)
                .set(URLS.TOKEN, url.getToken())
                .where(URLS.ORIGINAL_URL.eq(url.getOriginalUrl()))
                .and(URLS.ID.eq(url.getDatabaseId()))
                .execute();

        // Return the shortened url
        return url;
    }
}
