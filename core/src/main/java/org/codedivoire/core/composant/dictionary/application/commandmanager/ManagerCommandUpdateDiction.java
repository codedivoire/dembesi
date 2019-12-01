package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.diction.UpdateDictionCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryDictionPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.diction.UpdateDiction;
import org.codedivoire.core.kernelshared.CommandManager;

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
