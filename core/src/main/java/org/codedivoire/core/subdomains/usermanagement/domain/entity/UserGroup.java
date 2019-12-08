package org.codedivoire.core.subdomains.usermanagement.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Entité du Groupe User
 *
 * @author Christian Amani 2019-11-24
 */
public class UserGroup implements Serializable {

  private UUID id;
  private String label;
  private String description;
  private boolean status;
  private List<Permission> permissions = new ArrayList<>();

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

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public List<Permission> getPermissions() {
    return permissions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserGroup)) {
      return false;
    }
    UserGroup that = (UserGroup) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, label, description, status, permissions);
  }

  public void addPermission(Permission permission) {
    boolean contient = permissions.contains(permission);
    if(!contient) {
      permissions.add(permission);
    }
  }

  public void removePermission(Permission permission) {
    if(permission != null) {
      permissions.remove(permission);
    }
  }


  public List<Permission> searchParentPermission() {
    return permissions.stream()
        .filter(permission -> permission.getParent() == null)
        .collect(Collectors.toList());
  }

  public List<Permission> searchPermissionChild() {
    return permissions.stream()
        .filter(permission -> permission.getParent() != null)
        .collect(Collectors.toList());
  }
}
