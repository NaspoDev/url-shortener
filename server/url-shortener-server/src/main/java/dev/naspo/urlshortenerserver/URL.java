package dev.naspo.urlshortenerserver;

import org.hibernate.validator.constraints.Length;

import java.util.Stack;

// URL Data class
public class URL {
    @org.hibernate.validator.constraints.URL
    private String originalURL;
    private int databaseId;
    private String token;

    private final int MAX_TOKEN_LENGTH = 5; // Max token length of 5.

    // No-arg constructor for json deserializer.
    public URL() {
//        this.token = generateToken();
    }

    // Converts the URL's auto_increment database id into base-62.
    // Because it is based on the auto_increment id, it will be unique every time.
//    private String generateToken() {
//
//    }
}
