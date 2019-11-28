package org.codedivoire.core.composant.dictionary.domain.entity;

import java.io.Serializable;
import java.util.Objects;


/**
 * Entité définition, contenant la définition d’un nom
 *
 * @author Christian Amani 2019-11-24
 */
public class Definition extends WordDictionary implements Serializable {

  private String content;
  private String englishContent;
  private String localLanguageContent;
  private Name owner;
  private Opinion opinion;

  public Definition() {

  }

  public Definition(String content, String englishContent, String localLanguage) {
    this.content = content;
    this.englishContent = englishContent;
    this.localLanguageContent = localLanguage;
  }

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

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), content, englishContent, localLanguageContent, owner,
            opinion);
  }
}
