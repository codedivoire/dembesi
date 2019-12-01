package org.codedivoire.core.composant.dictionary.application.usecase.diction;

import org.codedivoire.core.composant.dictionary.application.command.diction.CreateDictionCommand;
import org.codedivoire.core.composant.dictionary.application.exception.InformationNotFound;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryDictionPort;
import org.codedivoire.core.composant.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.composant.dictionary.domain.entity.Diction;
import org.codedivoire.core.composant.dictionary.domain.entity.Name;

/**
 * Use case for {@link Diction} creation
 *
 * @author Christian Amani 2019-12-01
 */
public class CreateDiction {

  protected final RepositoryDictionPort repositoryDictionPort;
  private final RepositoryNamePort repositoryNamePort;

  public CreateDiction(
      RepositoryDictionPort repositoryDictionPort,
      RepositoryNamePort repositoryNamePort) {
    this.repositoryDictionPort = repositoryDictionPort;
    this.repositoryNamePort = repositoryNamePort;
  }

  public void create(CreateDictionCommand command) {
    Name name = findName(command);
    var diction = updateProperties(command, name);
    repositoryDictionPort.add(diction);
  }

  protected Diction updateProperties(CreateDictionCommand command, Name name) {
    var pronunciation = command.getPronunciation();
    var uriAudio = command.getUriAudio();
    return name.addNewDiction(pronunciation, uriAudio);
  }

  protected Name findName(CreateDictionCommand command) {
    var idName = command.getIdName();
    Name name = repositoryNamePort.find(idName);
    if (name != null) {
      return name;
    }
    throw new InformationNotFound();
  }
}
