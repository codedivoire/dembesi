package org.codedivoire.apirest.config;

/**
 * Les constantes utilisé dans l'application
 * @author Christian Amani
 */
public final class Constants {

    // Expression régulière accepter pour le login
    public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String DEFAULT_LANGUAGE = "en";
    public static final String ANONYMOUS_USER = "anonymoususer";

    private Constants() {
    }
}
