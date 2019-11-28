package org.codedivoire.apirest.config.properties;

import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

/**
 * @author Christian Amani
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

  private final Async async = new Async();

  private final Security security = new Security();

  private final CorsConfiguration cors = new CorsConfiguration();

  private final ClientApp clientApp = new ClientApp();

  public Security getSecurity() {
    return security;
  }

  public Async getAsync() {
    return async;
  }

  public CorsConfiguration getCors() {
    return cors;
  }

  public ClientApp getClientApp() {
    return clientApp;
  }

  public static class Async {

    private int corePoolSize = PropertiesDefaultValue.Async.corePoolSize;

    private int maxPoolSize = PropertiesDefaultValue.Async.maxPoolSize;

    private int queueCapacity = PropertiesDefaultValue.Async.queueCapacity;

    private String threadPrefix = PropertiesDefaultValue.Async.prefix;

    public int getCorePoolSize() {
      return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
      this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
      return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
      this.maxPoolSize = maxPoolSize;
    }

    public int getQueueCapacity() {
      return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
      this.queueCapacity = queueCapacity;
    }

    public String getThreadPrefix() {
      return threadPrefix;
    }
  }

  public static class Security {

    private final Authentication authentication = new Authentication();

    private final RememberMe rememberMe = new RememberMe();

    public Authentication getAuthentication() {
      return authentication;
    }

    public RememberMe getRememberMe() {
      return rememberMe;
    }

    public static class Authentication {

      private final Jwt jwt = new Jwt();

      public Jwt getJwt() {
        return jwt;
      }

      public static class Jwt {

        private String secret = PropertiesDefaultValue.Security.Authentication.Jwt.secret;

        private String base64Secret = PropertiesDefaultValue.Security.Authentication.Jwt.base64Secret;

        private long tokenValidityInSeconds = PropertiesDefaultValue.Security.Authentication.Jwt
            .tokenValidityInSeconds;

        private long tokenValidityInSecondsForRememberMe = PropertiesDefaultValue.Security.Authentication.Jwt
            .tokenValidityInSecondsForRememberMe;

        public String getSecret() {
          return secret;
        }

        public void setSecret(String secret) {
          this.secret = secret;
        }

        public String getBase64Secret() {
          return base64Secret;
        }

        public void setBase64Secret(String base64Secret) {
          this.base64Secret = base64Secret;
        }

        public long getTokenValidityInSeconds() {
          return tokenValidityInSeconds;
        }

        public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
          this.tokenValidityInSeconds = tokenValidityInSeconds;
        }

        public long getTokenValidityInSecondsForRememberMe() {
          return tokenValidityInSecondsForRememberMe;
        }

        public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
          this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
        }
      }
    }

    public static class RememberMe {

      @NotNull
      private String key = PropertiesDefaultValue.Security.RememberMe.key;

      public String getKey() {
        return key;
      }

      public void setKey(String key) {
        this.key = key;
      }
    }
  }

  public static class ClientApp {

    private String name = PropertiesDefaultValue.ClientApp.name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
