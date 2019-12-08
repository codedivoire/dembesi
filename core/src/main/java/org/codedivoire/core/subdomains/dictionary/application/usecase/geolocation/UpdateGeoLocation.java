package org.codedivoire.core.subdomains.dictionary.application.usecase.geolocation;

import org.codedivoire.core.subdomains.dictionary.application.command.geolocation.UpdateGeoLocationCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryGeoLocalisationPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.domain.entity.GeoLocation;

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
