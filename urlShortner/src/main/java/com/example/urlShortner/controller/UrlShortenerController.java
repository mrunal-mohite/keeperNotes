package com.example.urlShortner.controller;

import com.example.urlShortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String url) {
        return urlService.shortenUrl(url);
    }

    @GetMapping("/{shortKey}")
    public String redirectUrl(@PathVariable String shortKey) {
        return urlService.getOriginalUrl(shortKey);
    }

    @GetMapping("/metrics")
    public Map<String, Integer> getTopDomains() {
        return urlService.getTop3Domains();
    }
}
