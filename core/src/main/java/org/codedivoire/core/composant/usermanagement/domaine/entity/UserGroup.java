package org.codedivoire.core.composant.usermanagement.domaine.entity;

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

  public void ajouterPermission(Permission permission) {
    boolean contient = permissions.contains(permission);
    if(!contient) {
      permissions.add(permission);
    }
  }

  public void supprimerPermission(Permission permission) {
    if(permission != null) {
      permissions.remove(permission);
    }
  }

  public boolean possedePermission(Permission permission){
    return (permissions.contains(permission));
  }


  public List<Permission> rechercherParentPermission() {
    return permissions.stream()
        .filter(permission -> permission.getParent() == null)
        .collect(Collectors.toList());
  }

  public List<Permission> rechercherPermissionEnfant() {
    return permissions.stream()
        .filter(permission -> permission.getParent() != null)
        .collect(Collectors.toList());
  }
}
