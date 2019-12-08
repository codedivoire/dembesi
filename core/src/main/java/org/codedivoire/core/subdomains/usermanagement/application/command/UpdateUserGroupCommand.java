package org.codedivoire.core.subdomains.usermanagement.application.command;

import java.util.UUID;
import javax.validation.constraints.NotNull;


/**
 * Commande pour la modification d'un groupe utilisateur
 *
 * @author Christian Amani 2019-11-24
 */
public class UpdateUserGroupCommand extends CreateUserGroupCommand {

  @NotNull
  private UUID id;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
