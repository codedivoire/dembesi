package org.codedivoire.core.subdomains.usermanagement.application.usecase.user;

import java.util.List;
import org.codedivoire.core.subdomains.usermanagement.application.command.CreateUserCommand;
import org.codedivoire.core.subdomains.usermanagement.application.port.EncryptDataPort;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryPermissionPort;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryUserGroupPort;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryUserPort;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.User;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.UserProfile;
import org.codedivoire.core.subdomains.usermanagement.domain.exception.LoginAlreadyUsed;

/**
 * Cas d'utilisation pour la création d'un utilisateur
 *
 * @author Christian Amani 2019-12-03
 */
public class CreateUser {

  private final EncryptDataPort encryptDataPort;
  private final RepositoryUserGroupPort userGroupPort;
  private final RepositoryPermissionPort repositoryPermissionPort;
  protected final RepositoryUserPort repositoryUserPort;

  public CreateUser(
      EncryptDataPort encryptDataPort,
      RepositoryUserGroupPort userGroupPort,
      RepositoryPermissionPort repositoryPermissionPort,
      RepositoryUserPort repositoryUserPort) {
    this.encryptDataPort = encryptDataPort;
    this.userGroupPort = userGroupPort;
    this.repositoryPermissionPort = repositoryPermissionPort;
    this.repositoryUserPort = repositoryUserPort;
  }


  public void create(CreateUserCommand command) {
    User user = new User();
    UserProfile userProfile = updateProperties(command, user);
    repositoryUserPort.add(user, userProfile);
  }

  protected UserProfile updateProperties(CreateUserCommand command, User user) {
    var login = command.getLogin();
    var exist = repositoryUserPort.loginExist(login);
    if (exist) {
      throw new LoginAlreadyUsed();
    }
    command.setLogin(login);
    var labelUserGroup = command.getUserGroup();
    var userGroup = userGroupPort.find(labelUserGroup);
    user.setUserGroup(userGroup);
    List<String> permissionsId = command.getPermissionsId();
    permissionsId.stream()
        .map(repositoryPermissionPort::find)
        .forEach(user::addPermission);
    var rawPassword = command.getPassword();
    var encryptedPassword = encryptDataPort.encrypt(rawPassword);
    user.setPassword(encryptedPassword);
    var lastName = command.getLastName();
    var firstName = command.getFirstName();
    var email = command.getEmail();
    var urlLogo = command.getUrlLogo();
    UserProfile userProfile = user.createUserProfile(lastName, firstName, email, urlLogo);
    var gender = command.getGender();
    userProfile.setGender(gender);
    var function = command.getFunction();
    userProfile.setFunction(function);
    var civility = command.getCivility();
    userProfile.setCivility(civility);
    var birthDate = command.getBirthDate();
    userProfile.setBirthDate(birthDate);
    var adress = command.getAddress();
    userProfile.setAddress(adress);
    return userProfile;
  }
}
