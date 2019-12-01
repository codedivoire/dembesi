package org.codedivoire.core.composant.dictionary.application.usecase.diction;

import org.codedivoire.core.composant.dictionary.application.command.diction.DeleteDictionCommand;
import org.codedivoire.core.composant.dictionary.application.exception.InformationNotFound;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryDictionPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.domain.entity.Diction;

/**
 * Use case for {@link Diction} deletion
 *
 * @author Christian Amani 2019-12-01
 */
public class DeleteDicition {

  private final RepositoryNamePort repositoryNamePort;
  private final RepositoryDictionPort repositoryDictionPort;

  public DeleteDicition(
      RepositoryNamePort repositoryNamePort,
      RepositoryDictionPort repositoryDictionPort) {
    this.repositoryNamePort = repositoryNamePort;
    this.repositoryDictionPort = repositoryDictionPort;
  }

  public void delete(DeleteDictionCommand command) {
    var idName = command.getIdName();
    var name = repositoryNamePort.find(idName);
    var idDiciton = command.getIdDiciton();
    var diction = repositoryDictionPort.find(idDiciton);
    if (diction != null && name != null) {
      name.removeDiction(diction);
      repositoryDictionPort.remove(diction);
    } else {
      throw new InformationNotFound();
    }
  }
}
