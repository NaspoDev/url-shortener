package dev.naspo.urlshortenerserver;

import dev.naspo.urlshortenerserver.utils.Base62Converter;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

// URL Data class
public class URL {
    @org.hibernate.validator.constraints.URL
    private String originalUrl;
    private int databaseId; // auto_increment mysql database id.
    private String token; // the unique token that will route to the original URL.

    private String shortenedUrl; // the full shortened url
    // token gets appended to this in getShortenedUrl() method.
    private final String BASE_URL = "https://lnk.naspoapps.com/";
    private final int MAX_TOKEN_LENGTH = 5; // Max token length of 5.

    // No-arg constructor for json deserializer.
    public URL() {
    }

    public URL(String originalURL, int databaseId) {
        this.originalUrl = originalURL;
        this.databaseId = databaseId;
        this.token = generateToken(); // generate token upon construction.
        this.shortenedUrl = BASE_URL + token; // set the shortenedUrl variable
    }

    // Converts the URL's auto_increment database id into base-62.
    // Because it is based on the auto_increment id, it will be unique every time.
    public String generateToken() {
        String base62Value = Base62Converter.convertToBase62(databaseId);

        // Validates that it's not greater than the MAX_TOKEN_LENGTH characters long.
        if (base62Value.length() > MAX_TOKEN_LENGTH) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Max URL storage limit reached!");
        } else {
            // sets and returns the generated token
            token = base62Value;
            return base62Value;
        }
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getToken() {
        return token;
    }

    public int getDatabaseId() {
        return databaseId;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }
}
