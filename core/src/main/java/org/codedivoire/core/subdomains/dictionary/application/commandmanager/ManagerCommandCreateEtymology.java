package org.codedivoire.core.subdomains.dictionary.application.commandmanager;

import org.codedivoire.core.kernelshared.CommandManager;
import org.codedivoire.core.subdomains.dictionary.application.command.etymology.CreateEtymologyCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryEtymologyPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.application.usecase.etymology.CreateEtymology;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Etymology;

/**
 * Manager for the command to create a {@link Etymology}
 *
 * @author Christian Amani 2019-12-01
 */
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
