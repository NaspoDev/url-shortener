package dev.naspo.urlshortenerserver;

import dev.naspo.urlshortenerserver.database.DatabaseService;
import static dev.naspo.urlshortenerserver.database.generated.Tables.*;

import org.jooq.DSLContext;
import org.jooq.Record1;
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
    private int lastDatabaseId;

    public URLController(@Autowired DatabaseService databaseService) {
        this.databaseService = databaseService;
        this.db = databaseService.getDslContext();
    }

    // TODO: get the last database id.
    private int getLastDatabaseId() {

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
    public String createShortenedURL(@RequestBody URL url) {
        // TODO: write logic...
        // Also see if JSON deserializer works properly. See if
        // it creates a URL object with just the expected originalUrl param.
    }
}
