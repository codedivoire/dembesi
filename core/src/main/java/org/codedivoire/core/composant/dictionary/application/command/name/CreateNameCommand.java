package org.codedivoire.core.composant.dictionary.application.command.name;

import javax.validation.constraints.NotBlank;
import org.codedivoire.core.composant.dictionary.domain.entity.Name;

/**
 * Command for creating a new {@link Name}
 *
 * @author Christian Amani 2019-11-26
 */
public class CreateNameCommand {

  private String name;
  private DefinitionCommand definition;
  private DictionCommand diction;
  private EtymologyCommand etymology;
  private GeoLocationCommand geoLocation;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DefinitionCommand getDefinition() {
    return definition;
  }

  public void setDefinition(
      DefinitionCommand definition) {
    this.definition = definition;
  }

  public DictionCommand getDiction() {
    return diction;
  }

  public void setDiction(
      DictionCommand diction) {
    this.diction = diction;
  }

  public EtymologyCommand getEtymology() {
    return etymology;
  }

  public void setEtymology(
      EtymologyCommand etymology) {
    this.etymology = etymology;
  }

  public GeoLocationCommand getGeoLocation() {
    return geoLocation;
  }

  public void setGeoLocation(
      GeoLocationCommand geoLocation) {
    this.geoLocation = geoLocation;
  }

  public static class GeoLocationCommand {

    @NotBlank
    private String region;
    private String localisation;

    public String getRegion() {
      return region;
    }

    public void setRegion(String region) {
      this.region = region;
    }

    public String getLocalisation() {
      return localisation;
    }

    public void setLocalisation(String localisation) {
      this.localisation = localisation;
    }
  }

  public static class EtymologyCommand {

    @NotBlank
    private String origin;
    private String originEnglishTranslate;

    public String getOrigin() {
      return origin;
    }

    public void setOrigin(String origin) {
      this.origin = origin;
    }

    public String getOriginEnglishTranslate() {
      return originEnglishTranslate;
    }

    public void setOriginEnglishTranslate(String originEnglishTranslate) {
      this.originEnglishTranslate = originEnglishTranslate;
    }
  }

  public static class DictionCommand {

    @NotBlank
    private String pronunciation;
    private String uriAudio;

    public String getPronunciation() {
      return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
      this.pronunciation = pronunciation;
    }

    public String getUriAudio() {
      return uriAudio;
    }

    public void setUriAudio(String uriAudio) {
      this.uriAudio = uriAudio;
    }
  }

  public static class DefinitionCommand {

    @NotBlank
    private String content;
    private String englishContent;
    private String localLanguageContent;

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public String getEnglishContent() {
      return englishContent;
    }

    public void setEnglishContent(String englishContent) {
      this.englishContent = englishContent;
    }

    public String getLocalLanguageContent() {
      return localLanguageContent;
    }

    public void setLocalLanguageContent(String localLanguageContent) {
      this.localLanguageContent = localLanguageContent;
    }
  }
}
