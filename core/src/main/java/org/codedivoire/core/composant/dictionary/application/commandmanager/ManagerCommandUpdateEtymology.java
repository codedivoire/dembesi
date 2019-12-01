package org.codedivoire.core.composant.dictionary.application.commandmanager;

import org.codedivoire.core.composant.dictionary.application.command.etymology.UpdateEtymologyCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryEtymologyPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.application.usecase.etymology.UpdateEtymology;
import org.codedivoire.core.composant.dictionary.domain.entity.Etymology;
import org.codedivoire.core.kernelshared.CommandManager;

/**
 * Manager for the command to update a {@link Etymology}
 *
 * @author Christian Amani 2019-12-01
 */
public class ManagerCommandUpdateEtymology implements CommandManager<UpdateEtymologyCommand> {

  private final UpdateEtymology updateEtymology;

  public ManagerCommandUpdateEtymology(RepositoryNamePort repositoryName,
      RepositoryEtymologyPort repositoryEtymologie) {
    updateEtymology = new UpdateEtymology(repositoryName, repositoryEtymologie);
  }

  @Override
  public void executed(UpdateEtymologyCommand command) {
    updateEtymology.update(command);
  }
}
