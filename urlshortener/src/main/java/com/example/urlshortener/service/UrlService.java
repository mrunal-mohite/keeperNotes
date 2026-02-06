package com.example.urlshortener.service;

import com.example.urlshortener.util.Base62Encoder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UrlService {

    // Stores original URL -> short URL
    private Map<String, String> longToShort = new HashMap<>();

    // Stores short key -> original URL
    private Map<String, String> shortToLong = new HashMap<>();

    // Stores domain count
    private Map<String, Integer> domainCount = new HashMap<>();

    private long counter = 1;

    private final String BASE_URL = "http://localhost:8081/api/";

    // Shorten URL
    public String shortenUrl(String originalUrl) {

        // if URL already exists, return same short URL
        if (longToShort.containsKey(originalUrl)) {
            return longToShort.get(originalUrl);
        }

        String shortKey = Base62Encoder.encode(counter++);
        String shortUrl = BASE_URL + shortKey;

        longToShort.put(originalUrl, shortUrl);
        shortToLong.put(shortKey, originalUrl);

        // extract domain name
        String domain = URI.create(originalUrl).getHost();
        domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);

        return shortUrl;
    }

    // get original URL using short key
    public String getOriginalUrl(String shortKey) {
        return shortToLong.get(shortKey);
    }

    // metrics API: top 3 domains
    public Map<String, Integer> getTop3Domains() {
        return domainCount.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(3)
                .collect(
                        LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                        Map::putAll
                );
    }
}
