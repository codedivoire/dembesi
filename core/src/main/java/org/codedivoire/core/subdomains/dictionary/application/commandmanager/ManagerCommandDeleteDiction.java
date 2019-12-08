package org.codedivoire.core.subdomains.dictionary.application.commandmanager;

import org.codedivoire.core.kernelshared.CommandManager;
import org.codedivoire.core.subdomains.dictionary.application.command.diction.DeleteDictionCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryDictionPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.application.usecase.diction.DeleteDicition;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Diction;

/**
 * Manager for the command to delete a {@link Diction}
 *
 * @author Christian Amani 2019-12-01
 */
public class ManagerCommandDeleteDiction implements CommandManager<DeleteDictionCommand> {

  private final DeleteDicition deleteDicition;

  public ManagerCommandDeleteDiction(RepositoryDictionPort repositoryDiction,
      RepositoryNamePort repositoryName) {
    deleteDicition = new DeleteDicition(repositoryName, repositoryDiction);
  }

  @Override
  public void executed(DeleteDictionCommand command) {
    deleteDicition.delete(command);
  }
}
