package org.codedivoire.core.composant.dictionary.application.port;

import java.util.UUID;
import org.codedivoire.core.composant.dictionary.domain.entity.Definition;
import org.codedivoire.core.composant.dictionary.domain.entity.Diction;
import org.codedivoire.core.composant.dictionary.domain.entity.Etymology;
import org.codedivoire.core.composant.dictionary.domain.entity.GeoLocation;
import org.codedivoire.core.composant.dictionary.domain.entity.Name;

/**
 * Repository {@link org.codedivoire.core.composant.dictionary.domain.entity.Name} port
 *
 * @author Christian Amani 2019-12-01
 */
public interface RepositoryNamePort {

  void add(Name name);

  void add(Name name, Definition definition, Diction diction, Etymology etymology,
      GeoLocation geoLocation);

  boolean exist(String value);

  Name find(UUID id);

}
