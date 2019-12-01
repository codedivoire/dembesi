package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.geolocation.DeleteGeoLocationCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryGeoLocalisationPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.geolocation.DeleteGeoLocation;
import org.codedivoire.core.composant.dictionary.domain.entity.GeoLocation;
import org.codedivoire.core.kernelshared.CommandManager;

/**
 * Manager for the command to delete a {@link GeoLocation}
 *
 * @author Christian Amani 2019-12-01
 */
public class ManagerCommandDeleteGeoLocation implements CommandManager<DeleteGeoLocationCommand> {

  private final DeleteGeoLocation deleteGeoLocation;

  public ManagerCommandDeleteGeoLocation(RepositoryNamePort repositoryName,
      RepositoryGeoLocalisationPort repositoryGeoLocation) {
    deleteGeoLocation = new DeleteGeoLocation(repositoryName, repositoryGeoLocation);
  }


  @Override
  public void executed(DeleteGeoLocationCommand command) {

  }
}
