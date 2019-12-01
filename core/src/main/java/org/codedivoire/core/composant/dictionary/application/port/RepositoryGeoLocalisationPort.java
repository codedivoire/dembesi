package org.codedivoire.core.composant.dictionary.application.port;

import java.util.UUID;
import org.codedivoire.core.composant.dictionary.domain.entity.GeoLocation;

/**
 * Repository {@link org.codedivoire.core.composant.dictionary.domain.entity.GeoLocation} port
 *
 * @author Christian Amani 2019-12-01
 */
public interface RepositoryGeoLocalisationPort {

  void add(GeoLocation geoLocation);

  GeoLocation find(UUID idGeoLocation);

  void remove(GeoLocation geoLocation);

}
