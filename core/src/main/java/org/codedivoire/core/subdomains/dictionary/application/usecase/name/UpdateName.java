package org.codedivoire.core.subdomains.dictionary.application.usecase.name;

import org.codedivoire.core.kernelshared.application.exception.InformationNotFound;
import org.codedivoire.core.subdomains.dictionary.application.command.name.UpdateNameCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Name;

/**
 * Use case for {@link org.codedivoire.core.subdomains.dictionary.domain.entity.Name} updating
 *
 * @author Christian Amani 2019-12-01
 */
public class UpdateName {

  private final RepositoryNamePort repositoryNamePort;

  public UpdateName(
      RepositoryNamePort repositoryNamePort) {
    this.repositoryNamePort = repositoryNamePort;
  }

  public void update(UpdateNameCommand command) {
    var id = command.getId();
    Name name = repositoryNamePort.find(id);
    if (name != null) {
      var value = command.getValue();
      name.setValue(value);
      var state = command.getState();
      name.setState(state);
      repositoryNamePort.add(name);
    }
    throw new InformationNotFound();
  }
}
