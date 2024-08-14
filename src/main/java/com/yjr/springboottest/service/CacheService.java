package com.yjr.springboottest.service;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CacheService {

    @Autowired
    private Cache<String, Integer> caffineCache;

    public void set(String key, Integer value) {
        caffineCache.put(key, value);
    }

    public Integer get(String key) {
        return caffineCache.getIfPresent(key);
    }

    public Set<String> getAllKeys() {
        return caffineCache.asMap().keySet();
    }
}
