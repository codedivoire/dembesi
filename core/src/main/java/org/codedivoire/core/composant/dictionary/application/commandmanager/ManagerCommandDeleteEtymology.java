package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.etymology.DeleteEtymologyCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryEtymologyPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.etymology.DeleteEtymology;
import org.codedivoire.core.kernelshared.CommandManager;

public class ManagerCommandDeleteEtymology implements CommandManager<DeleteEtymologyCommand> {

  private final DeleteEtymology deleteEtymology;

  public ManagerCommandDeleteEtymology(RepositoryNamePort repositoryName,
      RepositoryEtymologyPort repositoryEtymologie) {
    deleteEtymology = new DeleteEtymology(repositoryEtymologie, repositoryName);
  }


  @Override
  public void executed(DeleteEtymologyCommand command) {
    deleteEtymology.delete(command);
  }
}
