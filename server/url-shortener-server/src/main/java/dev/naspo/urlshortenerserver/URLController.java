package dev.naspo.urlshortenerserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Handles requests to "/urls"
@RestController
@RequestMapping("/urls")
public class URLController {

    // Get original url from token
    @GetMapping("/{token}")
    public String getOriginalURL(@PathVariable("token") String token) {
        // Make a db request to get og url from the token
    }

}
