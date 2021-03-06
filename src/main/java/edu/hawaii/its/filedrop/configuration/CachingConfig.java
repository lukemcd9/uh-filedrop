package edu.hawaii.its.filedrop.configuration;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("default"),
                new ConcurrentMapCache("campuses"),
                new ConcurrentMapCache("campusesAll"),
                new ConcurrentMapCache("campusesActualAll"),
                new ConcurrentMapCache("campusesById"),
                new ConcurrentMapCache("offices"),
                new ConcurrentMapCache("officesById"),
                new ConcurrentMapCache("personCache"),
                new ConcurrentMapCache("personByIdCache"),
                new ConcurrentMapCache("roles"),
                new ConcurrentMapCache("rolesById"),
                new ConcurrentMapCache("rolesCache"),
                new ConcurrentMapCache("rolesByIdCache"),
                new ConcurrentMapCache("messages"),
                new ConcurrentMapCache("settings"),
                new ConcurrentMapCache("settingsById"),
                new ConcurrentMapCache("allowlistCache"),
                new ConcurrentMapCache("allowlistById"),
                new ConcurrentMapCache("faqCache"),
                new ConcurrentMapCache("faqById")));
        return cacheManager;
    }

}