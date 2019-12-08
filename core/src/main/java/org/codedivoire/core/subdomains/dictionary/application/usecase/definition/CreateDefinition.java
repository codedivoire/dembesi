package org.codedivoire.core.subdomains.dictionary.application.usecase.definition;

import org.codedivoire.core.kernelshared.application.exception.InformationNotFound;
import org.codedivoire.core.subdomains.dictionary.application.command.definition.CreateDefinitionCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryDefinitionPort;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Definition;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Name;

/**
 * Use case for {@link Definition} creation
 *
 * @author Christian Amani 2019-12-01
 */
public class CreateDefinition {

  protected final RepositoryDefinitionPort repositoryDefinitionPort;
  private final RepositoryNamePort repositoryNamePort;

  public CreateDefinition(
      RepositoryDefinitionPort repositoryDefinitionPort,
      RepositoryNamePort repositoryNamePort) {
    this.repositoryDefinitionPort = repositoryDefinitionPort;
    this.repositoryNamePort = repositoryNamePort;
  }

  public void create(CreateDefinitionCommand command) {
    Name name = findName(command);
    Definition definition = updateProperties(command, name);
    repositoryDefinitionPort.add(definition);
  }

  protected Definition updateProperties(CreateDefinitionCommand command, Name name) {
    var content = command.getContent();
    var englishContent = command.getEnglishContent();
    var localLanguageContent = command.getLocalLanguageContent();
    return name.addNewDefinition(content, englishContent, localLanguageContent);
  }

  protected Name findName(CreateDefinitionCommand command) {
    var idName = command.getIdName();
    Name name = repositoryNamePort.find(idName);
    if (name != null) {
      return name;
    }
    throw new InformationNotFound();
  }
}
