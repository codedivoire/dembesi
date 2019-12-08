package org.codedivoire.core.subdomains.dictionary.domain.entity;


import java.io.Serializable;
import java.util.Objects;

/**
 * Entité étymologie, définie l’étymologie d’un nom
 *
 * @author Christian Amani 2019-11-24
 */
public class Etymology extends WordDictionary implements Serializable {

  private String origin;
  private String originEnglishTranslate;
  private Opinion opinion;
  private Name owner;

  public Etymology() {

  }

  public Etymology(String origin, String originEnglishTranslate) {
    this.origin = origin;
    this.originEnglishTranslate = originEnglishTranslate;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
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

  public String getOriginEnglishTranslate() {
    return originEnglishTranslate;
  }

  public void setOriginEnglishTranslate(String originEnglishTranslate) {
    this.originEnglishTranslate = originEnglishTranslate;
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), origin, originEnglishTranslate, opinion, owner);
  }
}
