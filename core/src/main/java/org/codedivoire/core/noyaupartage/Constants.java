package org.codedivoire.core.noyaupartage;

/**
 * Classe pour la définition des constantes
 *
 * @author Christian Amani 2019-11-24
 */
public final class Constants {

  // Expression régulière accepter pour le login
  public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";
  public static final String URL_DOSSIER_IMAGE = "public/images";
  public static final String LOGO_PAR_DEFAUT = "assets/image/placeholder-company.png";
  public static final String GROUPE_UTILISATEUR_ROOT = "GROUPE_UTILISATEUR_ROOT";
  public static final String GROUPE_UTILISATEUR_SYSTEME = "GROUPE_UTILISATEUR_SYSTEME";
  public static final String SYSTEME_MOT_PASSE = "P@ssw0rd*2019";
  public static final String SYSTEME_LOGIN = "SYSTEME_LOGIN";
  public static final String SYSTEME_RAISON_SOCIALE = "INEXA";
  public static final String SYSTEME_RCCM = "INEXA-RCCM";
  public static final String SYSTEME_EMAIL = "support@inexa-ci.com";
  public static final String REGEX_MOT_PASSE = "^(?=.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$";

  private Constants() {
  }
}
