package com.md.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class CachingConfig {
    @Bean
    public CacheManager cacheManager(){
        return new ConcurrentMapCacheManager("prices");
    }

    @Scheduled(fixedRate = 60000) // cache eviction every 1min
    public void evictAllcachesAtIntervals() {
        cacheManager().getCacheNames().stream()
                .forEach(cacheName -> cacheManager().getCache(cacheName).clear());
    }
}
