package org.codedivoire.core.subdomains.dictionary.application.commandmanager;

import org.codedivoire.core.kernelshared.CommandManager;
import org.codedivoire.core.subdomains.dictionary.application.command.definition.UpdateDefinitionCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryDefinitionPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.application.usecase.definition.UpdateDefinition;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Definition;

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
