package org.codedivoire.core.composant.dictionary.application.usecase.geolocation;

import org.codedivoire.core.composant.dictionary.application.command.geolocation.DeleteGeoLocationCommand;
import org.codedivoire.core.composant.dictionary.application.exception.InformationNotFound;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryGeoLocalisationPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.domain.entity.Name;

public class DeleteGeoLocation {

  private final RepositoryNamePort repositoryNamePort;
  private final RepositoryGeoLocalisationPort repositoryGeoLocalisationPort;

  public DeleteGeoLocation(
      RepositoryNamePort repositoryNamePort,
      RepositoryGeoLocalisationPort repositoryGeoLocalisationPort) {
    this.repositoryNamePort = repositoryNamePort;
    this.repositoryGeoLocalisationPort = repositoryGeoLocalisationPort;
  }

  public void delete(DeleteGeoLocationCommand command) {
    var idGeoLocation = command.getIdGeoLocation();
    var geoLocation = repositoryGeoLocalisationPort.find(idGeoLocation);
    var idName = command.getIdName();
    Name name = repositoryNamePort.find(idName);
    if (geoLocation != null && name != null) {
      name.removeGeoLocation(geoLocation);
      repositoryGeoLocalisationPort.remove(geoLocation);
    } else {
      throw new InformationNotFound();
    }
  }
}
