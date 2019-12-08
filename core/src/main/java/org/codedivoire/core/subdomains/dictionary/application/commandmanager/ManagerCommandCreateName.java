package org.codedivoire.core.subdomains.dictionary.application.commandmanager;

import org.codedivoire.core.kernelshared.CommandManager;
import org.codedivoire.core.subdomains.dictionary.application.command.name.CreateNameCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.application.usecase.name.CreateName;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Name;

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
