package org.codedivoire.core.kernelshared;

/**
 * Classe pour la définition des constantes
 *
 * @author Christian Amani 2019-11-24
 */
public final class Constants {

  public static final String SYSTEME_MOT_PASSE = "P@ssw0rd*2019";
  public static final String SYSTEME_LOGIN = "SYSTEME_LOGIN";
  public static final String SYSTEME_EMAIL = "support@dembesi.com";
  public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";
  public static final String REGEX_MOT_PASSE = "^(?=.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$";

  private Constants() {
  }
}
