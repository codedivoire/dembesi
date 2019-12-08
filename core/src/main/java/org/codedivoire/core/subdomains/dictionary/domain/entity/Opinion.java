package org.codedivoire.core.subdomains.dictionary.domain.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Répresente une opinion porté sur information
 *
 * @author Christian Amani 2019-11-24
 */
public class Opinion implements Serializable {

  private UUID id;
  private OpinionType opinionType;
  private UUID authorId;

  public Opinion() {
  }

  public Opinion(OpinionType opinionType, UUID authorOpinionId) {
    this.opinionType = opinionType;
    this.authorId = authorOpinionId;
  }

  public OpinionType getOpinionType() {
    return opinionType;
  }

  public void setOpinionType(
      OpinionType opinionType) {
    this.opinionType = opinionType;
  }

  public UUID getAuthorId() {
    return authorId;
  }

  public void setAuthorId(UUID authorId) {
    this.authorId = authorId;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Opinion)) {
      return false;
    }
    Opinion opinion = (Opinion) o;
    return id.equals(opinion.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, opinionType, authorId);
  }

  public enum OpinionType {
    REJECT, FAVOR
  }
}
