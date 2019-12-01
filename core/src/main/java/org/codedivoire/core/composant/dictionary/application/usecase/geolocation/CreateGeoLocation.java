package org.codedivoire.core.composant.dictionary.application.usecase.geolocation;

import org.codedivoire.core.composant.dictionary.application.command.geolocation.CreateGeoLocationCommand;
import org.codedivoire.core.composant.dictionary.application.exception.InformationNotFound;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryGeoLocalisationPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.domain.entity.GeoLocation;
import org.codedivoire.core.composant.dictionary.domain.entity.Name;

/**
 * Use case for {@link GeoLocation} creation
 *
 * @author Christian Amani 2019-12-01
 */
public class CreateGeoLocation {

  private final RepositoryNamePort repositoryNamePort;
  protected final RepositoryGeoLocalisationPort repositoryGeoLocalisationPort;

  public CreateGeoLocation(
      RepositoryNamePort repositoryNamePort,
      RepositoryGeoLocalisationPort repositoryGeoLocalisationPort) {
    this.repositoryNamePort = repositoryNamePort;
    this.repositoryGeoLocalisationPort = repositoryGeoLocalisationPort;
  }

  public void create(CreateGeoLocationCommand command) {
    var name = findName(command);
    var geoLocation = updateProperties(command, name);
    repositoryGeoLocalisationPort.add(geoLocation);
  }


  protected GeoLocation updateProperties(CreateGeoLocationCommand command, Name name) {
    var localisation = command.getLocalisation();
    var region = command.getRegion();
    return name.addNewGeoLocation(localisation, region);
  }

  protected Name findName(CreateGeoLocationCommand command) {
    var idName = command.getIdName();
    Name name = repositoryNamePort.find(idName);
    if (name != null) {
      return name;
    }
    throw new InformationNotFound();
  }
}
