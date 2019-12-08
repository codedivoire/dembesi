package org.codedivoire.core.subdomains.dictionary.application.commandmanager;

import org.codedivoire.core.kernelshared.CommandManager;
import org.codedivoire.core.subdomains.dictionary.application.command.name.UpdateNameCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.application.usecase.name.UpdateName;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Name;

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
