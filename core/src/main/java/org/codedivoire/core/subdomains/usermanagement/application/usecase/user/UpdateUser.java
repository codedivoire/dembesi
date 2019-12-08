package org.codedivoire.core.subdomains.usermanagement.application.usecase.user;

import org.codedivoire.core.subdomains.usermanagement.application.command.UpdateUserCommand;
import org.codedivoire.core.subdomains.usermanagement.application.port.EncryptDataPort;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryPermissionPort;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryUserGroupPort;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryUserPort;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.User;

/**
 * Cas d'utilisation pour la modification d'un utilisateur
 *
 * @author Christian Amani 2019-12-08
 */
public class UpdateUser extends CreateUser {

  public UpdateUser(
      EncryptDataPort encryptDataPort,
      RepositoryUserGroupPort userGroupPort,
      RepositoryPermissionPort repositoryPermissionPort,
      RepositoryUserPort repositoryUserPort) {
    super(encryptDataPort, userGroupPort, repositoryPermissionPort, repositoryUserPort);
  }

  public void update(UpdateUserCommand command) {
    User user = new User();
    var userProfile = updateProperties(command, user);
    var userId = command.getUserId();
    var profileId = command.getProfileId();
    userProfile.setId(profileId);
    user.setId(userId);
    repositoryUserPort.add(user, userProfile);
  }
}
