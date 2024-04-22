package dev.naspo.urlshortenerserver;

import dev.naspo.urlshortenerserver.database.DatabaseConnection;
import static dev.naspo.urlshortenerserver.database.generated.Tables.*;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Handles requests to "/urls"
@RestController
@RequestMapping("/urls")
public class URLController {

    private final DSLContext db = DatabaseConnection.getInstance().getDslContext();

    // Get original url from token
    @GetMapping("/{token}")
    public String getOriginalURL(@PathVariable("token") String token) {
        Result<Record> result = db.select().from(URLS).fetch();
    }

}
