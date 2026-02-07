package com.example.urlShortner.service;

import com.example.urlShortner.util.Base62Encoder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UrlService {

    private Map<String, String> longToShort = new HashMap<>();
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, Integer> domainCount = new HashMap<>();
    private long counter = 1;

    private final String BASE_URL = "http://localhost:8081/api/";

    public String shortenUrl(String originalUrl) {

        if (originalUrl == null || originalUrl.isEmpty()) {
            return "Invalid URL";
        }

        if (longToShort.containsKey(originalUrl)) {
            return longToShort.get(originalUrl);
        }

        String shortKey = Base62Encoder.encode(counter++);
        String shortUrl = BASE_URL + shortKey;

        longToShort.put(originalUrl, shortUrl);
        shortToLong.put(shortKey, originalUrl);

        String domain = URI.create(originalUrl).getHost();
        domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);

        return shortUrl;
    }

    public String getOriginalUrl(String shortKey) {
        return shortToLong.get(shortKey);
    }

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
