package org.codedivoire.core.composant.dictionary.application.port;

import java.util.UUID;
import org.codedivoire.core.composant.dictionary.domain.entity.Definition;

/**
 * Repository {@link org.codedivoire.core.composant.dictionary.domain.entity.Definition} port
 *
 * @author Christian Amani 2019-12-01
 */
public interface RepositoryDefinitionPort {

  void add(Definition definition);

  Definition find(UUID idDefinition);

  void remove(Definition definition);
}
