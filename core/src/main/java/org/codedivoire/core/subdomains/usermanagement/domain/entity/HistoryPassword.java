package org.codedivoire.core.subdomains.usermanagement.domain.entity;

import java.time.Instant;
import java.util.UUID;

/**
 * Entité pour l'historisation des mots de passe
 *
 * @author Christian Amani 2019-11-24
 */
public class HistoryPassword {

  private UUID id;
  private String password;
  private Instant creationDate;
  private User user;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(
      User user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Instant getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Instant creationDate) {
    this.creationDate = creationDate;
  }
}
