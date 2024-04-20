package dev.naspo.urlshortenerserver;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

// URL Data class
public class URL {
    @org.hibernate.validator.constraints.URL
    @NotNull
    private String originalURL;
    private int databaseId;
    @Max(5)
    private String token;

    private final int MAX_TOKEN_LENGTH = 5; // Max token length of 5.

    // No-arg constructor for json deserializer.
    public URL() {
        this.token = generateToken();
    }

    // Converts the URL's auto_increment database id into base-62.
    // Because it is based on the auto_increment id, it will be unique every time.
    private String generateToken() {
        char[] hashCode = new char[MAX_TOKEN_LENGTH];


    }
}
