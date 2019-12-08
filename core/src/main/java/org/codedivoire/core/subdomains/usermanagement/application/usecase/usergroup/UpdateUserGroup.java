package org.codedivoire.core.subdomains.usermanagement.application.usecase.usergroup;

import org.codedivoire.core.subdomains.usermanagement.application.command.UpdateUserGroupCommand;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryPermissionPort;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryUserGroupPort;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.UserGroup;

/**
 * Cas d'utilisation pour la modification d'un groupe utilisateur
 *
 * @author Christian Amani 2019-12-08
 */
public class UpdateUserGroup extends CreateUserGroup {

  public UpdateUserGroup(
      RepositoryUserGroupPort repositoryUserGroupPort,
      RepositoryPermissionPort repositoryPermissionPort) {
    super(repositoryUserGroupPort, repositoryPermissionPort);
  }

  public void update(UpdateUserGroupCommand command) {
    UserGroup userGroup = new UserGroup();
    updateProperties(command, userGroup);
    var userGroupId = command.getId();
    userGroup.setId(userGroupId);
    repositoryUserGroupPort.add(userGroup);
  }
}
