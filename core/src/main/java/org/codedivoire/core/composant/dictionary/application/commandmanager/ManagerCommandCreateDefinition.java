package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.definition.CreateDefinitionCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryDefinitionPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.definition.CreateDefinition;
import org.codedivoire.core.composant.dictionary.domain.entity.Definition;
import org.codedivoire.core.kernelshared.CommandManager;

/**
 * Manager for the command to create a {@link Definition}
 *
 * @author Christian Amani 2019-12-01
 */
public class ManagerCommandCreateDefinition implements CommandManager<CreateDefinitionCommand> {

  private final CreateDefinition createDefinition;

  public ManagerCommandCreateDefinition(
      RepositoryDefinitionPort repositoryDeinfition,
      RepositoryNamePort repositoryName) {
    createDefinition = new CreateDefinition(repositoryDeinfition, repositoryName);
  }

  @Override
  public void executed(CreateDefinitionCommand command) {
    createDefinition.create(command);
  }
}
