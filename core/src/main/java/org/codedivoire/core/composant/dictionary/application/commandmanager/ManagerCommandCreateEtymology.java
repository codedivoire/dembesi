package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.etymology.CreateEtymologyCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryEtymologyPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.etymology.CreateEtymology;
import org.codedivoire.core.kernelshared.CommandManager;

public class ManagerCommandCreateEtymology implements CommandManager<CreateEtymologyCommand> {

  private final CreateEtymology createEtymology;

  public ManagerCommandCreateEtymology(
      RepositoryNamePort repositoryName,
      RepositoryEtymologyPort repositoryEtymologie) {
    createEtymology = new CreateEtymology(repositoryName, repositoryEtymologie);
  }


  @Override
  public void executed(CreateEtymologyCommand command) {
    createEtymology.create(command);
  }
}
