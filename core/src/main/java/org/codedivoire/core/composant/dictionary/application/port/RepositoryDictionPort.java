package org.codedivoire.core.composant.dictionary.application.port;

import java.util.UUID;
import org.codedivoire.core.composant.dictionary.domain.entity.Diction;

/**
 * Repository {@link org.codedivoire.core.composant.dictionary.domain.entity.Diction} port
 *
 * @author Christian Amani 2019-12-01
 */
public interface RepositoryDictionPort {

  void add(Diction diction);

  Diction find(UUID idDiciton);

  void remove(Diction diction);
}
