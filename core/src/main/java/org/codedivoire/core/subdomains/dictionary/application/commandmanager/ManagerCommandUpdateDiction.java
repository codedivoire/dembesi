package org.codedivoire.core.subdomains.dictionary.application.commandmanager;

import org.codedivoire.core.kernelshared.CommandManager;
import org.codedivoire.core.subdomains.dictionary.application.command.diction.UpdateDictionCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryDictionPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.application.usecase.diction.UpdateDiction;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Diction;

/**
 * Manager for the command to update a {@link Diction}
 *
 * @author Christian Amani 2019-12-01
 */
public class ManagerCommandUpdateDiction implements CommandManager<UpdateDictionCommand> {

  private final UpdateDiction updateDiction;

  public ManagerCommandUpdateDiction(
      RepositoryDictionPort repositoryDiction,
      RepositoryNamePort repositoryName) {
    updateDiction = new UpdateDiction(repositoryDiction, repositoryName);
  }

  @Override
  public void executed(UpdateDictionCommand command) {
    updateDiction.update(command);
  }
}
