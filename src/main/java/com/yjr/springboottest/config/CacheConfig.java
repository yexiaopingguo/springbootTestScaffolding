package com.yjr.springboottest.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {
    @Bean
    public Cache<String, Integer> caffeineCache() {
        return Caffeine.newBuilder()
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .maximumSize(3)
                .build();
    }
}
