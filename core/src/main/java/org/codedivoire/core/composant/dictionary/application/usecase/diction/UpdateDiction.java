package org.codedivoire.core.composant.dictionary.application.usecase.diction;

import org.codedivoire.core.composant.dictionary.application.command.diction.UpdateDictionCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryDictionPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.domain.entity.Diction;

/**
 * Use case for {@link Diction} updating
 *
 * @author Christian Amani 2019-12-01
 */
public class UpdateDiction extends CreateDiction {

  public UpdateDiction(
      RepositoryDictionPort repositoryDictionPort,
      RepositoryNamePort repositoryNamePort) {
    super(repositoryDictionPort, repositoryNamePort);
  }

  public void update(UpdateDictionCommand command) {
    var name = findName(command);
    Diction diction = updateProperties(command, name);
    var id = command.getId();
    diction.setId(id);
    var state = command.getState();
    diction.setState(state);
    repositoryDictionPort.add(diction);
  }
}
