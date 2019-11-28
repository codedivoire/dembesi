package org.codedivoire.core.composant.dictionary.domain.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * Entité diction, correspond à la diction d’un nom
 *
 * @author Christian Amani 2019-11-24
 */
public class Diction extends WordDictionary implements Serializable {

  private String pronunciation;
  private String uriAudio;
  private Name owner;
  private Opinion opinion;

  public Diction() {

  }

  public Diction(String pronunuciation, String uriAudio) {
    this.pronunciation = pronunuciation;
    this.uriAudio = uriAudio;
  }

  public String getPronunciation() {
    return pronunciation;
  }

  public void setPronunciation(String pronunciation) {
    this.pronunciation = pronunciation;
  }

  public String getUriAudio() {
    return uriAudio;
  }

  public void setAudioStream(String uriAudio) {
    this.uriAudio = uriAudio;
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
    return Objects.hash(super.hashCode(), pronunciation, uriAudio, owner, opinion);
  }
}
