package org.codedivoire.core.composant.dictionary.application.usecase.geolocation;

import org.codedivoire.core.composant.dictionary.application.command.geolocation.UpdateGeoLocationCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryGeoLocalisationPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.domain.entity.GeoLocation;

public class UpdateGeoLocation extends CreateGeoLocation {

  public UpdateGeoLocation(
      RepositoryNamePort repositoryNamePort,
      RepositoryGeoLocalisationPort repositoryGeoLocalisationPort) {
    super(repositoryNamePort, repositoryGeoLocalisationPort);
  }

  public void update(UpdateGeoLocationCommand command) {
    var name = findName(command);
    GeoLocation geoLocation = updateProperties(command, name);
    var id = command.getId();
    geoLocation.setId(id);
    var state = command.getState();
    geoLocation.setState(state);
    repositoryGeoLocalisationPort.add(geoLocation);
  }
}
