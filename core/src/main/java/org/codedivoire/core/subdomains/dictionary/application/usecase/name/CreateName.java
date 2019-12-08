package org.codedivoire.core.subdomains.dictionary.application.usecase.name;

import org.codedivoire.core.subdomains.dictionary.application.command.name.CreateNameCommand;
import org.codedivoire.core.subdomains.dictionary.application.port.RepositoryNamePort;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Definition;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Diction;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Etymology;
import org.codedivoire.core.subdomains.dictionary.domain.entity.GeoLocation;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Name;
import org.codedivoire.core.subdomains.dictionary.domain.exception.NameAlreadyExistInDictionary;

/**
 * Use case for {@link org.codedivoire.core.subdomains.dictionary.domain.entity.Name} creation
 *
 * @author Christian Amani 2019-12-01
 */
public class CreateName {

  private final RepositoryNamePort repositoryNamePort;


  public CreateName(
      RepositoryNamePort repositoryNamePort) {
    this.repositoryNamePort = repositoryNamePort;
  }

  public void create(CreateNameCommand command) {
    String value = command.getName();
    boolean exist = repositoryNamePort.exist(value);
    if (!exist) {
      Name name = new Name(value);
      var commandDefinition = command.getDefinition();
      String content = commandDefinition.getContent();
      String englishContent = commandDefinition.getEnglishContent();
      String localLanguageContent = commandDefinition.getLocalLanguageContent();
      Definition definition = name.addNewDefinition(content, englishContent, localLanguageContent);
      var commandDiction = command.getDiction();
      String pronunciation = commandDiction.getPronunciation();
      String uriAudio = commandDiction.getUriAudio();
      Diction diction = name.addNewDiction(pronunciation, uriAudio);
      var commandEtymology = command.getEtymology();
      String origin = commandEtymology.getOrigin();
      String originEnglishTranslate = commandEtymology.getOriginEnglishTranslate();
      Etymology etymology = name.addNewEtymology(origin, originEnglishTranslate);
      var commandGeoLocation = command.getGeoLocation();
      String localisation = commandGeoLocation.getLocalisation();
      String region = commandGeoLocation.getRegion();
      GeoLocation geoLocation = name.addNewGeoLocation(region, localisation);
      repositoryNamePort.add(name, definition, diction, etymology, geoLocation);
    } else {
      throw new NameAlreadyExistInDictionary();
    }
  }
}
