package org.codedivoire.apirest.config.properties;

/**
 * @author Christian Amani
 */
public interface PropertiesDefaultValue {

  interface Async {

    int corePoolSize = 2;
    int maxPoolSize = 50;
    int queueCapacity = 10000;
    String prefix = "Async";
  }

  interface ClientApp {
    String name = "";
  }

  interface Security {

    interface ClientAuthorization {

      String accessTokenUri = null;
      String tokenServiceId = null;
      String clientId = null;
      String clientSecret = null;
    }

    interface Authentication {

      interface Jwt {

        String secret = null;
        String base64Secret = null;
        long tokenValidityInSeconds = 1800; // 0.5 hour
        long tokenValidityInSecondsForRememberMe = 2592000; // 30 hours;
      }
    }

    interface RememberMe {

      String key = null;
    }
  }

}
