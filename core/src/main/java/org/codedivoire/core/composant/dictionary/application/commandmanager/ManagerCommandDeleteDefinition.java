package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.definition.DeleteDefinitionCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryDefinitionPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.definition.DeleteDefinition;
import org.codedivoire.core.composant.dictionary.domain.entity.Definition;
import org.codedivoire.core.kernelshared.CommandManager;

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
