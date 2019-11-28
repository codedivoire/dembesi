package org.codedivoire.core.composant.usermanagement.application.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.codedivoire.core.noyaupartage.Constants;

/**
 * Commande pour la mise à jour d'un mot de passe
 *
 * @author Christian Amani 2019-10-25
 */
public class UpdatePasswordCommand {

  private String login;
  @NotBlank
  @Size(min = 8, max = 100)
  @Pattern(regexp = Constants.REGEX_MOT_PASSE)
  private String ancienMotPasse;
  @NotBlank
  @Size(min = 8, max = 100)
  @Pattern(regexp = Constants.REGEX_MOT_PASSE)
  private String nouveauMotPasse;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getNouveauMotPasse() {
    return nouveauMotPasse;
  }

  public void setNouveauMotPasse(String nouveauMotPasse) {
    this.nouveauMotPasse = nouveauMotPasse;
  }

  public String getAncienMotPasse() {
    return ancienMotPasse;
  }

  public void setAncienMotPasse(String ancienMotPasse) {
    this.ancienMotPasse = ancienMotPasse;
  }
}
