package org.codedivoire.core.subdomains.usermanagement.application.command;

import java.util.UUID;
import javax.validation.constraints.NotNull;

/**
 * Commande pour la modification d'un utilisateur physique
 *
 * @author Christian Amani 2019-10-28
 */
public class UpdateUserCommand extends CreateUserCommand {

  @NotNull
  private UUID userId;
  @NotNull
  private UUID profileId;
  private boolean locked;

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public void setLocked(boolean locked) {
    this.locked = locked;
  }

  public boolean isLocked() {
    return locked;
  }

  public UUID getProfileId() {
    return profileId;
  }

  public void setProfileId(UUID profileId) {
    this.profileId = profileId;
  }
}
