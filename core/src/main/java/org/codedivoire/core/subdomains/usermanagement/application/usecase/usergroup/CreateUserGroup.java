package org.codedivoire.core.subdomains.usermanagement.application.usecase.usergroup;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.codedivoire.core.subdomains.usermanagement.application.command.CreateUserGroupCommand;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryPermissionPort;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryUserGroupPort;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.Permission;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.UserGroup;

/**
 * Cas d'utilisation pour la création d'un groupe utilisateur
 *
 * @author Christian Amani 2019-12-08
 */
public class CreateUserGroup {

  protected final RepositoryUserGroupPort repositoryUserGroupPort;
  private final RepositoryPermissionPort repositoryPermissionPort;

  public CreateUserGroup(
      RepositoryUserGroupPort repositoryUserGroupPort,
      RepositoryPermissionPort repositoryPermissionPort) {
    this.repositoryUserGroupPort = repositoryUserGroupPort;
    this.repositoryPermissionPort = repositoryPermissionPort;
  }

  public void create(CreateUserGroupCommand command) {
    UserGroup userGroup = new UserGroup();
    updateProperties(command, userGroup);
    repositoryUserGroupPort.add(userGroup);
  }

  protected void updateProperties(CreateUserGroupCommand command, UserGroup userGroup) {
    var description = command.getDescription();
    userGroup.setDescription(description);
    var libelle = command.getLabel();
    userGroup.setLabel(libelle);
    Set<String> permissions = command.getPermissions();
    List<Permission> permissionList = permissions.stream()
        .map(repositoryPermissionPort::find)
        .collect(Collectors.toList());
    permissionList.forEach(userGroup::addPermission);
  }
}
