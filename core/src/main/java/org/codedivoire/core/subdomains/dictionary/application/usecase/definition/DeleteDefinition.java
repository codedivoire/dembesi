package org.codedivoire.core.subdomains.dictionary.application.usecase.definition;

import org.codedivoire.core.kernelshared.application.exception.InformationNotFound;
import org.codedivoire.core.subdomains.dictionary.application.command.definition.DeleteDefinitionCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryDefinitionPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Definition;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Name;

/**
 * Use case for {@link Definition} deletion
 *
 * @author Christian Amani 2019-12-01
 */
public class DeleteDefinition {

  private final RepositoryDefinitionPort repositoryDefinitionPort;
  private final RepositoryNamePort repositoryNamePort;

  public DeleteDefinition(
      RepositoryDefinitionPort repositoryDefinitionPort,
      RepositoryNamePort repositoryNamePort) {
    this.repositoryDefinitionPort = repositoryDefinitionPort;
    this.repositoryNamePort = repositoryNamePort;
  }

  public void delete(DeleteDefinitionCommand command) {
    var idDefinition = command.getIdDefinition();
    var definition = repositoryDefinitionPort.find(idDefinition);
    var idName = command.getIdName();
    Name name = repositoryNamePort.find(idName);
    if (definition != null && name != null) {
      name.removeDefinition(definition);
      repositoryDefinitionPort.remove(definition);
    } else {
      throw new InformationNotFound();
    }
  }
}
