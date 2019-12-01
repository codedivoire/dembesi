package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.name.CreateNameCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.name.CreateName;
import org.codedivoire.core.composant.dictionary.domain.entity.Name;
import org.codedivoire.core.kernelshared.CommandManager;

/**
 * Manager for the command to create a {@link Name}
 *
 * @author Christian Amani 2019-12-01
 */
public class ManagerCommandCreateName implements CommandManager<CreateNameCommand> {

  private final CreateName createName;

  public ManagerCommandCreateName(
      RepositoryNamePort repositoryName) {
    createName = new CreateName(repositoryName);
  }

  @Override
  public void executed(CreateNameCommand command) {
    createName.create(command);
  }
}
