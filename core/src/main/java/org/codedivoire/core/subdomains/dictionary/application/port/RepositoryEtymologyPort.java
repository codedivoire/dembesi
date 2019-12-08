package org.codedivoire.core.subdomains.dictionary.application.port;

import java.util.UUID;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Etymology;

/**
 * Repository {@link org.codedivoire.core.subdomains.dictionary.domain.entity.Etymology} port
 *
 * @author Christian Amani 2019-12-01
 */
public interface RepositoryEtymologyPort {

  void add(Etymology etymology);

  Etymology find(UUID idEtymology);

  void remove(Etymology etymology);
}
