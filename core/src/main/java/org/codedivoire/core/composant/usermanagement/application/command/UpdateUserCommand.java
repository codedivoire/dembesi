package org.codedivoire.core.composant.usermanagement.application.command;

import java.util.UUID;
import javax.validation.constraints.NotNull;

/**
 * Commande pour la modification d'un utilisateur physique
 *
 * @author Christian Amani 2019-10-28
 */
public class UpdateUserCommand extends CreerUserCommand {

  @NotNull
  private UUID utilisateurId;
  private boolean verrouille;

  public UUID getUtilisateurId() {
    return utilisateurId;
  }

  public void setUtilisateurId(UUID utilisateurId) {
    this.utilisateurId = utilisateurId;
  }

  public void setVerrouille(boolean verrouille) {
    this.verrouille = verrouille;
  }

  public boolean isVerrouille() {
    return verrouille;
  }
}
