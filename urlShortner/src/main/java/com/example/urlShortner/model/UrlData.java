package com.example.urlShortner.model;

public class UrlData {

    private String originalUrl;
    private String shortCode;

    public UrlData(String originalUrl, String shortCode) {
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortCode() {
        return shortCode;
    }
}
