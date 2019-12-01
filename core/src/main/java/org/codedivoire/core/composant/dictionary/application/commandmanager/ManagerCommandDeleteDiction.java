package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.diction.DeleteDictionCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryDictionPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.diction.DeleteDicition;
import org.codedivoire.core.kernelshared.CommandManager;

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
