package org.codedivoire.core.composant.dictionary.application.usecase.etymology;

import org.codedivoire.core.composant.dictionary.application.command.etymology.UpdateEtymologyCommand;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryEtymologyPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.domain.entity.Etymology;

public class UpdateEtymology extends CreateEtymology {

  public UpdateEtymology(
      RepositoryNamePort repositoryNamePort,
      RepositoryEtymologyPort repositoryEtymologyPort) {
    super(repositoryNamePort, repositoryEtymologyPort);
  }

  public void update(UpdateEtymologyCommand command) {
    var name = findName(command);
    Etymology etymology = updateProperties(command, name);
    var id = command.getId();
    etymology.setId(id);
    var state = command.getState();
    etymology.setState(state);
    repositoryEtymologyPort.add(etymology);
  }
}
