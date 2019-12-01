package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.diction.CreateDictionCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryDictionPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.diction.CreateDiction;
import org.codedivoire.core.composant.dictionary.domain.entity.Diction;
import org.codedivoire.core.kernelshared.CommandManager;

/**
 * Manager for the command to create a {@link Diction}
 *
 * @author Christian Amani 2019-12-01
 */
public class ManagerCommandCreateDiction implements CommandManager<CreateDictionCommand> {

  private final CreateDiction createDiction;

  public ManagerCommandCreateDiction(
      RepositoryDictionPort repositoryDiction,
      RepositoryNamePort repositoryName) {
    createDiction = new CreateDiction(repositoryDiction, repositoryName);
  }

  @Override
  public void executed(CreateDictionCommand command) {
    createDiction.create(command);
  }
}
