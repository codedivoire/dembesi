package org.codedivoire.core.composant.usermanagement.domain.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Entité de Permission
 *
 * @author Christian Amani 2019-11-24
 */
public class Permission implements Serializable {

  private UUID id;
  private String label;
  private String description;
  private Permission parent;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Permission getParent() {
    return parent;
  }

  public void setParent(
      Permission parent) {
    this.parent = parent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Permission)) {
      return false;
    }
    Permission that = (Permission) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, label, description);
  }
}
