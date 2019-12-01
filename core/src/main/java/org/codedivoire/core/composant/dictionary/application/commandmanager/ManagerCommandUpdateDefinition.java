package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.definition.UpdateDefinitionCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryDefinitionPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.definition.UpdateDefinition;
import org.codedivoire.core.composant.dictionary.domain.entity.Definition;
import org.codedivoire.core.kernelshared.CommandManager;

/**
 * Manager for the command to update a {@link Definition}
 *
 * @author Christian Amani 2019-12-01
 */
public class ManagerCommandUpdateDefinition implements CommandManager<UpdateDefinitionCommand> {

  private final UpdateDefinition updateDefinition;

  public ManagerCommandUpdateDefinition(
      RepositoryDefinitionPort repositoryDeinfition,
      RepositoryNamePort repositoryName) {

    updateDefinition = new UpdateDefinition(repositoryDeinfition, repositoryName);
  }

  @Override
  public void executed(UpdateDefinitionCommand command) {
    updateDefinition.update(command);
  }
}
