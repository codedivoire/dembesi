package org.codedivoire.core.subdomains.usermanagement.application.command;

import java.util.Set;
import java.util.UUID;
import javax.validation.constraints.NotNull;

/**
 * Commande pour l'ajout de permissions à un groupe utilisateur
 *
 * @author Christian Amani 2019-11-24
 */
public class AddPermissionsToUserGroupCommand {

  private Set<String> permissions;
  @NotNull
  private UUID groupeUtilisateurId;

  public Set<String> getPermissions() {
    return permissions;
  }

  public void setPermissions(Set<String> permissions) {
    this.permissions = permissions;
  }

  public UUID getGroupeUtilisateurId() {
    return groupeUtilisateurId;
  }

  public void setGroupeUtilisateurId(UUID groupeUtilisateurId) {
    this.groupeUtilisateurId = groupeUtilisateurId;
  }
}
