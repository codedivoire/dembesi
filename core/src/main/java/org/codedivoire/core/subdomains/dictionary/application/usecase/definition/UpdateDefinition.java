package org.codedivoire.core.subdomains.dictionary.application.usecase.definition;

import org.codedivoire.core.subdomains.dictionary.application.command.definition.UpdateDefinitionCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryDefinitionPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Definition;

/**
 * Use case for {@link Definition} updating
 *
 * @author Christian Amani 2019-12-01
 */
public class UpdateDefinition extends CreateDefinition {

  public UpdateDefinition(
      RepositoryDefinitionPort repositoryDefinitionPort,
      RepositoryNamePort repositoryNamePort) {
    super(repositoryDefinitionPort, repositoryNamePort);
  }

  public void update(UpdateDefinitionCommand command) {
    var name = findName(command);
    Definition definition = updateProperties(command, name);
    var id = command.getId();
    definition.setId(id);
    var state = command.getState();
    definition.setState(state);
    repositoryDefinitionPort.add(definition);
  }
}
