package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.geolocation.UpdateGeoLocationCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryGeoLocalisationPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.geolocation.UpdateGeoLocation;
import org.codedivoire.core.kernelshared.CommandManager;

public class ManagerCommandUpdateGeoLocation implements CommandManager<UpdateGeoLocationCommand> {

  private final UpdateGeoLocation updateGeoLocation;

  public ManagerCommandUpdateGeoLocation(RepositoryNamePort repositoryName,
      RepositoryGeoLocalisationPort repositoryGeoLocation) {
    updateGeoLocation = new UpdateGeoLocation(repositoryName, repositoryGeoLocation);
  }

  @Override
  public void executed(UpdateGeoLocationCommand command) {
    updateGeoLocation.update(command);
  }
}
