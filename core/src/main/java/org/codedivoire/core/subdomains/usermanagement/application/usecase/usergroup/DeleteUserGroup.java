package org.codedivoire.core.subdomains.usermanagement.application.usecase.usergroup;

import java.util.UUID;
import org.codedivoire.core.kernelshared.application.exception.UnableDeleteInformation;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryUserGroupPort;

/**
 * Cas d'utilisation pour la suppression d'un groupe utilisateur
 *
 * @author Christian Amani 2019-12-08
 */
public class DeleteUserGroup {

  private final RepositoryUserGroupPort repositoryUserGroupPort;

  public DeleteUserGroup(
      RepositoryUserGroupPort repositoryUserGroupPort) {
    this.repositoryUserGroupPort = repositoryUserGroupPort;
  }

  public void delete(UUID userGroupId) {
    long numberUsersWhoUseGroup = repositoryUserGroupPort.searchNumberUsersWhoUseGroup(userGroupId);
    if (numberUsersWhoUseGroup == 0) {
      repositoryUserGroupPort.remove(userGroupId);
    } else {
      throw new UnableDeleteInformation();
    }
  }
}
