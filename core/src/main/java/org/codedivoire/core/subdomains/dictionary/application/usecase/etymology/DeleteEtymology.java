package org.codedivoire.core.subdomains.dictionary.application.usecase.etymology;

import org.codedivoire.core.kernelshared.application.exception.InformationNotFound;
import org.codedivoire.core.subdomains.dictionary.application.command.etymology.DeleteEtymologyCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryEtymologyPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Etymology;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Name;

/**
 * Use case for {@link Etymology} deletion
 *
 * @author Christian Amani 2019-12-01
 */
public class DeleteEtymology {

  private final RepositoryEtymologyPort repositoryEtymologyPort;
  private final RepositoryNamePort repositoryNamePort;

  public DeleteEtymology(
      RepositoryEtymologyPort repositoryEtymologyPort,
      RepositoryNamePort repositoryNamePort) {
    this.repositoryEtymologyPort = repositoryEtymologyPort;
    this.repositoryNamePort = repositoryNamePort;
  }

  public void delete(DeleteEtymologyCommand command) {
    var idEtymology = command.getIdEtymology();
    var etymology = repositoryEtymologyPort.find(idEtymology);
    var idName = command.getIdName();
    Name name = repositoryNamePort.find(idName);
    if (etymology != null && name != null) {
      name.removeEtymology(etymology);
      repositoryEtymologyPort.remove(etymology);
    } else {
      throw new InformationNotFound();
    }
  }
}
