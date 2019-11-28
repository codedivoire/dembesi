package org.codedivoire.core.composant.dictionary.domain.entity;

import java.io.Serializable;
import java.util.Objects;
import org.codedivoire.core.composant.dictionary.domain.valueobject.MediaType;

/**
 * Entité media d'un nom
 *
 * @author Christian Amani 2019-11-24
 */
public class MediaLink extends WordDictionary implements Serializable {

  private String uri;
  private String caption;
  private String captionEnglishTranslate;
  private MediaType mediaType;
  private Opinion opinion;
  private Name owner;

  public MediaLink() {

  }

  public MediaLink(String uri, String caption, String captionEnglishTranslate,
      MediaType mediaType) {
    this.uri = uri;
    this.caption = caption;
    this.captionEnglishTranslate = captionEnglishTranslate;
    this.mediaType = mediaType;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }


  public Name getOwner() {
    return owner;
  }

  public void setOwner(Name owner) {
    this.owner = owner;
  }

  public Opinion getOpinion() {
    return opinion;
  }

  public void setOpinion(Opinion opinion) {
    this.opinion = opinion;
  }

  public String getCaptionEnglishTranslate() {
    return captionEnglishTranslate;
  }

  public void setCaptionEnglishTranslate(String captionEnglishTranslate) {
    this.captionEnglishTranslate = captionEnglishTranslate;
  }

  public MediaType getMediaType() {
    return mediaType;
  }

  public void setMediaType(MediaType mediaType) {
    this.mediaType = mediaType;
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), uri, caption, captionEnglishTranslate, mediaType,
            opinion, owner);
  }
}
