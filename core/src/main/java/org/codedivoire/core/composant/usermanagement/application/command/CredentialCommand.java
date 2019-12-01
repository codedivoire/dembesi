package org.codedivoire.core.composant.usermanagement.application.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.codedivoire.core.kernelshared.Constants;

/**
 * Commande des informations de credentials (d'accès)
 * @author Christian Amani 2019-11-24
 */
public class CredentialCommand {

  @NotNull
  @Size(min = 1, max = 50)
  private String username;

  @NotNull
  @Size(min = 8, max = 100)
  @Pattern(regexp = Constants.REGEX_MOT_PASSE)
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
