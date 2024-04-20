package dev.naspo.urlshortenerserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Handles requests to "/urls"
@RestController
@RequestMapping("/urls")
public class URLController {

    // Testing routing
    @GetMapping("")
    public String getHelloWorld() {
        return "Hello World!";
    }
}
