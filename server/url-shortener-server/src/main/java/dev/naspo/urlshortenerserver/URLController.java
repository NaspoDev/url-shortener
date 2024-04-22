package dev.naspo.urlshortenerserver;

import dev.naspo.urlshortenerserver.database.DatabaseService;
import static dev.naspo.urlshortenerserver.database.generated.Tables.*;

import jakarta.annotation.PostConstruct;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Result<Record> result = databaseService.getDslContext().select().from(URLS).fetch();
    }

}
