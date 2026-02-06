package com.example.urlShortner.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String url) {
        return "Short URL will come here";
    }
}
