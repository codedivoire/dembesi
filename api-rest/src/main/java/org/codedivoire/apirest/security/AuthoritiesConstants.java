package org.codedivoire.apirest.security;

/**
 * Classe stockant toutes les constantes d'habilitations
 * @author Christian Amani 2019-08-27
 */
public final class AuthoritiesConstants {

    public static final String ADMIN = "ROLE_ADMIN";

    public static final String USER = "ROLE_USER";

    public static final String ANONYMOUS = "ROLE_ANONYMOUS";

    private AuthoritiesConstants() {
    }
}
