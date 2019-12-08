package org.codedivoire.core.subdomains.dictionary.application.commandmanager;

import org.codedivoire.core.kernelshared.CommandManager;
import org.codedivoire.core.subdomains.dictionary.application.command.etymology.UpdateEtymologyCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryEtymologyPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.application.usecase.etymology.UpdateEtymology;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Etymology;

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
