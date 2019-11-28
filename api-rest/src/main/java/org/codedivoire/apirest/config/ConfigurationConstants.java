package org.codedivoire.apirest.config;

/**
 * Classe stockant toutes les constantes utilisé dans le projet
 * @author Christian Amani
 */
public final class ConfigurationConstants {

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";

    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    private ConfigurationConstants() {
      throw new UnsupportedOperationException();
    }

}
