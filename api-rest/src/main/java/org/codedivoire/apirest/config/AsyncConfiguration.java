package org.codedivoire.apirest.config;

import java.util.concurrent.Executor;
import org.codedivoire.apirest.config.properties.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Classe de configuration pour l'executor qui lancera les tâches asynchrones
 * @author Christian Amani
 */
@Configuration
@EnableAsync
@EnableScheduling
public class AsyncConfiguration implements AsyncConfigurer {

  private final Logger log = LoggerFactory.getLogger(AsyncConfiguration.class);

  private final ApplicationProperties applicationProperties;

  public AsyncConfiguration(ApplicationProperties applicationProperties) {
    this.applicationProperties = applicationProperties;
  }

  @Override
  @Bean(name = "taskExecutor")
  public Executor getAsyncExecutor() {
    log.debug("Creating Async Task Executor");
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(applicationProperties.getAsync().getCorePoolSize());
    executor.setMaxPoolSize(applicationProperties.getAsync().getMaxPoolSize());
    executor.setQueueCapacity(applicationProperties.getAsync().getQueueCapacity());
    executor.setThreadNamePrefix(applicationProperties.getAsync().getThreadPrefix());
    return executor;
  }

  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return new SimpleAsyncUncaughtExceptionHandler();
  }
}
