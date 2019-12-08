package org.codedivoire.core.subdomains.dictionary.application.commandmanager;

import org.codedivoire.core.kernelshared.CommandManager;
import org.codedivoire.core.subdomains.dictionary.application.command.etymology.DeleteEtymologyCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryEtymologyPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.application.usecase.etymology.DeleteEtymology;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Etymology;

/**
 * Manager for the command to delete a {@link Etymology}
 *
 * @author Christian Amani 2019-12-01
 */
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
