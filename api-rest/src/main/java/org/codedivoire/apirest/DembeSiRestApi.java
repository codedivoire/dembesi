package org.codedivoire.apirest;

import org.codedivoire.apirest.config.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Christian Amani 2019-11-27
 */
@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class DembeSiRestApi {

  public static void main(String[] args) {
    SpringApplication.run(DembeSiRestApi.class, args);
  }
}
