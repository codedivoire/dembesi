package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.name.UpdateNameCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.name.UpdateName;
import org.codedivoire.core.composant.dictionary.domain.entity.Name;
import org.codedivoire.core.kernelshared.CommandManager;

/**
 * Manager for the command to update a {@link Name}
 *
 * @author Christian Amani 2019-12-01
 */
public class ManagerCommandUpdateName implements CommandManager<UpdateNameCommand> {

  private final UpdateName updateName;

  public ManagerCommandUpdateName(RepositoryNamePort repositoryName) {
    updateName = new UpdateName(repositoryName);
  }

  @Override
  public void executed(UpdateNameCommand command) {
    updateName.update(command);
  }
}
