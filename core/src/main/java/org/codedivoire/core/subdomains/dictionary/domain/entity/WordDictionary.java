package org.codedivoire.core.subdomains.dictionary.domain.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Opinion.OpinionType;
import org.codedivoire.core.subdomains.dictionary.domain.valueobject.State;

/**
 * Classe de base pour tous les entités du domaine dictionnaire
 *
 * @author Christian Amani 2019-11-26
 */
public abstract class WordDictionary implements Serializable {

  private UUID id;
  private List<Opinion> opinions;
  private UUID authorId;
  private State state;


  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getAuthorId() {
    return authorId;
  }

  public void setAuthorId(UUID authorId) {
    this.authorId = authorId;
  }

  public List<Opinion> getOpinions() {
    return opinions;
  }

  public void setOpinions(
      List<Opinion> opinions) {
    this.opinions = opinions;
  }

  public State getState() {
    return state;
  }

  public void addNewOpinion(OpinionType opinionType,UUID authorOpinionId) {
    Opinion opinion = new Opinion(opinionType,authorOpinionId);
    opinions.add(opinion);
  }

  public void setState(State state) {
    this.state = state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WordDictionary)) {
      return false;
    }
    WordDictionary that = (WordDictionary) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, opinions,authorId,state);
  }
}
