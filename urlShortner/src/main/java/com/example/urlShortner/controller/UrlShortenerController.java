package com.example.urlShortner.controller;

import com.example.urlShortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


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
    public void redirectUrl(@PathVariable String shortKey, HttpServletResponse response) throws IOException {
        String originalUrl = urlService.getOriginalUrl(shortKey);

        if (originalUrl != null) {
            response.sendRedirect(originalUrl);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Short URL not found");
        }
    }


    @GetMapping("/metrics")
    public Map<String, Integer> getTopDomains() {
        return urlService.getTop3Domains();
    }
}
