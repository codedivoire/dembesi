package org.codedivoire.core.subdomains.dictionary.application.commandmanager;

import org.codedivoire.core.kernelshared.CommandManager;
import org.codedivoire.core.subdomains.dictionary.application.command.definition.DeleteDefinitionCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryDefinitionPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.application.usecase.definition.DeleteDefinition;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Definition;

/**
 * Manager for the command to delete a {@link Definition}
 *
 * @author Christian Amani 2019-12-01
 */
public class ManagerCommandDeleteDefinition implements CommandManager<DeleteDefinitionCommand> {

  private final DeleteDefinition deleteDefinition;

  public ManagerCommandDeleteDefinition(
      RepositoryDefinitionPort repositoryDefinition,
      RepositoryNamePort repositoryName) {
    deleteDefinition = new DeleteDefinition(repositoryDefinition, repositoryName);
  }


  @Override
  public void executed(DeleteDefinitionCommand command) {
    deleteDefinition.delete(command);
  }
}
