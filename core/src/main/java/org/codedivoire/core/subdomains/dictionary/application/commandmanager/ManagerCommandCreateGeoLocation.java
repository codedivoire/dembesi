package org.codedivoire.core.subdomains.dictionary.application.commandmanager;

import org.codedivoire.core.kernelshared.CommandManager;
import org.codedivoire.core.subdomains.dictionary.application.command.geolocation.CreateGeoLocationCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryGeoLocalisationPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.application.usecase.geolocation.CreateGeoLocation;
import org.codedivoire.core.subdomains.dictionary.domain.entity.GeoLocation;

/**
 * Manager for the command to create a {@link GeoLocation}
 *
 * @author Christian Amani 2019-12-01
 */
public class ManagerCommandCreateGeoLocation implements CommandManager<CreateGeoLocationCommand> {

  private final CreateGeoLocation createGeoLocation;

  public ManagerCommandCreateGeoLocation(
      RepositoryNamePort repositoryName,
      RepositoryGeoLocalisationPort repositoryGeoLocation) {
    createGeoLocation = new CreateGeoLocation(repositoryName, repositoryGeoLocation);
  }

  @Override
  public void executed(CreateGeoLocationCommand command) {
    createGeoLocation.create(command);
  }
}
