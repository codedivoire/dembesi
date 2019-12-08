package org.codedivoire.core.subdomains.usermanagement.application.usecase.user;

import org.codedivoire.core.subdomains.usermanagement.application.command.UpdateUserProfileCommand;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryProfilePort;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.UserProfile;

/**
 * Cas d'utilisation pour la mise à jour d'un profile
 *
 * @author Christian Amani 2019-12-08
 */
public class UpdateUserProfile {

  private final RepositoryProfilePort repositoryProfilePort;

  public UpdateUserProfile(
      RepositoryProfilePort repositoryProfilePort) {
    this.repositoryProfilePort = repositoryProfilePort;
  }

  public void update(UpdateUserProfileCommand command) {
    UserProfile userProfile = new UserProfile();
    var userProfileId = command.getId();
    userProfile.setId(userProfileId);
    var address = command.getAddress();
    userProfile.setAddress(address);
    var lastName = command.getLastName();
    userProfile.setLastName(lastName);
    var civility = command.getCivility();
    userProfile.setCivility(civility);
    var gender = command.getGender();
    userProfile.setGender(gender);
    var firstName = command.getFirstName();
    userProfile.setFirstName(firstName);
    var logoUrl = command.getLogoUrl();
    userProfile.setLogoUrl(logoUrl);
    var birthDate = command.getBirthDate();
    userProfile.setBirthDate(birthDate);
    var function = command.getFunction();
    userProfile.setFunction(function);
    repositoryProfilePort.add(userProfile);
  }
}
