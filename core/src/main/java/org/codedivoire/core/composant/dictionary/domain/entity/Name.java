package org.codedivoire.core.composant.dictionary.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.codedivoire.core.composant.dictionary.domain.valueobject.MediaType;
import org.codedivoire.core.composant.dictionary.domain.valueobject.State;

/**
 * Entité nom, réprésente un nom de famille
 *
 * @author Christian Amani 2019-11-24
 */
public class Name extends WordDictionary implements Serializable {

  private String name;
  private List<Definition> definitions = new ArrayList<>();
  private List<Diction> dictions = new ArrayList<>();
  private List<Etymology> etymologies = new ArrayList<>();
  private List<GeoLocation> geoLocations = new ArrayList<>();
  private List<MediaLink> mediaLinkList = new ArrayList<>();

  public Name() {
  }

  public Name(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Definition> getDefinitions() {
    return definitions;
  }

  public void setDefinitions(
      List<Definition> definitions) {
    this.definitions = definitions;
  }

  public List<Diction> getDictions() {
    return dictions;
  }

  public void setDictions(
      List<Diction> dictions) {
    this.dictions = dictions;
  }

  public List<Etymology> getEtymologies() {
    return etymologies;
  }

  public void setEtymologies(
      List<Etymology> etymologies) {
    this.etymologies = etymologies;
  }

  public List<GeoLocation> getGeoLocations() {
    return geoLocations;
  }

  public void setGeoLocations(
      List<GeoLocation> geoLocations) {
    this.geoLocations = geoLocations;
  }

  public List<MediaLink> getMediaLinkList() {
    return mediaLinkList;
  }

  public void setMediaLinkList(
      List<MediaLink> mediaLinkList) {
    this.mediaLinkList = mediaLinkList;
  }

  public void addNewDefinition(String content, String englishContent, String localLanguage) {
    Definition definition = new Definition(content, englishContent, localLanguage);
    definition.setOwner(this);
    definition.setState(State.NEW);
    definitions.add(definition);
  }

  public void removeDefinition(Definition definition) {
    if (definition != null) {
      definitions.remove(definition);
      definition.setOwner(null);
    }
  }

  public Optional<Definition> findDefinition(UUID definitionId) {
    return definitions.stream()
        .filter(definition -> definition.getId() == definitionId)
        .findFirst();
  }

  public void changeStateOfDefinition(State state, UUID definitionId) {
    Optional<Definition> optionalDefinition = findDefinition(definitionId);
    optionalDefinition.ifPresent(definition -> definition.setState(state));
  }

  public void addNewDiction(String pronunuciation, String uriAudio) {
    Diction diction = new Diction(pronunuciation, uriAudio);
    diction.setOwner(this);
    diction.setState(State.NEW);
    dictions.add(diction);
  }

  public void removeDiction(Diction diction) {
    if (diction != null) {
      dictions.remove(diction);
      diction.setOwner(null);
    }
  }

  public void changeStateOfDiction(State state, UUID dictionId) {
    Optional<Diction> optionalDiction = findDiction(dictionId);
    optionalDiction.ifPresent(diction -> diction.setState(state));
  }

  public Optional<Diction> findDiction(UUID dictionId) {
    return dictions.stream()
        .filter(diction -> diction.getId() == dictionId)
        .findFirst();
  }

  public Etymology addNewEtymology(String origin, String originEnglishTranslate) {
    Etymology etymology = new Etymology(origin, originEnglishTranslate);
    etymology.setOwner(this);
    etymology.setState(State.NEW);
    return etymology;
  }

  public void removeEtymology(Etymology etymology) {
    if (etymology != null) {
      etymologies.remove(etymology);
      etymology.setOwner(null);
    }
  }

  public void changeStateOfEtymology(State state, UUID etymotologyID) {
    Optional<Etymology> optionalEtymology = findEtymology(etymotologyID);
    optionalEtymology.ifPresent(etymology -> etymology.setState(state));
  }

  public Optional<Etymology> findEtymology(UUID etymotologyID) {
    return etymologies.stream()
        .filter(etymology -> etymology.getId() == etymotologyID)
        .findFirst();
  }

  public GeoLocation addNewGeoLocation(String region, String localisation) {
    GeoLocation geoLocation = new GeoLocation(region, localisation);
    geoLocation.setOwner(this);
    geoLocation.setState(State.NEW);
    return geoLocation;
  }

  public void removeGeoLocation(GeoLocation geoLocation) {
    if (geoLocation != null) {
      geoLocations.remove(geoLocation);
      geoLocation.setOwner(null);
    }
  }

  public void changeStateOfGeoLocation(State state, UUID geoLocationId) {
    Optional<GeoLocation> optionalGeoLocation = findGeolocation(geoLocationId);
    optionalGeoLocation.ifPresent(geoLocation -> geoLocation.setState(state));
  }

  public Optional<GeoLocation> findGeolocation(UUID geoLocationId) {
    return geoLocations.stream()
        .filter(geoLocation -> geoLocation.getId() == geoLocationId)
        .findFirst();
  }

  public MediaLink addNewMediaLink(String uri, String caption, String captionEnglishTranslate,
      MediaType mediaType) {
    MediaLink mediaLink = new MediaLink(uri, caption, captionEnglishTranslate, mediaType);
    mediaLink.setOwner(this);
    mediaLink.setState(State.NEW);
    return mediaLink;
  }

  public void removeMediaLink(MediaLink mediaLink) {
    if (mediaLink != null) {
      mediaLinkList.remove(mediaLink);
      mediaLink.setOwner(null);
    }
  }

  public void changeStateOfMediaLink(State state, UUID mediaLinkId) {
    Optional<MediaLink> optionalMediaLink = findMediaLink(mediaLinkId);
    optionalMediaLink.ifPresent(mediaLink -> mediaLink.setState(state));
  }

  public Optional<MediaLink> findMediaLink(UUID mediaLinkId) {
    return mediaLinkList.stream()
        .filter(mediaLink -> mediaLink.getId() == mediaLinkId)
        .findFirst();
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), name, definitions, dictions, etymologies, geoLocations,
            mediaLinkList);
  }
}
