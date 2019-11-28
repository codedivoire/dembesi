package org.codedivoire.apirest.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Christian Amani on 12/10/19.
 */
@EnableCaching
@Configuration
public class CacheConfiguration  {

  @Bean
  public CacheManager cacheManager() {
    return new CaffeineCacheManager();
  }
}
