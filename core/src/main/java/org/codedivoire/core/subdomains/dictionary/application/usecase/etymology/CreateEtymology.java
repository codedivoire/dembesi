package org.codedivoire.core.subdomains.dictionary.application.usecase.etymology;

import org.codedivoire.core.kernelshared.application.exception.InformationNotFound;
import org.codedivoire.core.subdomains.dictionary.application.command.etymology.CreateEtymologyCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryEtymologyPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Etymology;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Name;

/**
 * Use case for {@link Etymology} creation
 *
 * @author Christian Amani 2019-12-01
 */
public class CreateEtymology {

  private final RepositoryNamePort repositoryNamePort;
  protected final RepositoryEtymologyPort repositoryEtymologyPort;

  public CreateEtymology(
      RepositoryNamePort repositoryNamePort,
      RepositoryEtymologyPort repositoryEtymologyPort) {
    this.repositoryNamePort = repositoryNamePort;
    this.repositoryEtymologyPort = repositoryEtymologyPort;
  }

  public void create(CreateEtymologyCommand command) {
    var name = findName(command);
    var etymology = updateProperties(command, name);
    repositoryEtymologyPort.add(etymology);
  }

  protected Etymology updateProperties(CreateEtymologyCommand command, Name name) {
    String origin = command.getOrigin();
    String originEnglishTranslate = command.getOriginEnglishTranslate();
    return name.addNewEtymology(origin, originEnglishTranslate);
  }

  protected Name findName(CreateEtymologyCommand command) {
    var idName = command.getIdName();
    Name name = repositoryNamePort.find(idName);
    if (name != null) {
      return name;
    }
    throw new InformationNotFound();
  }
}
