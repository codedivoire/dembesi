package org.codedivoire.core.composant.usermanagement.domaine.valueobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Objet valeur d'un arbre de permission
 *
 * @author Christian Amani 2019-11-24
 */
public class PermissionTree {

  private String id;
  private String parentId;
  private String libelle;
  private String description;
  private String parentLibelle;
  private String parentDesciption;
  private List<PermissionTree> enfants = new ArrayList<>();

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public List<PermissionTree> getEnfants() {
    return enfants;
  }

  public void setEnfants(
      List<PermissionTree> permissionTrees) {
    this.enfants = permissionTrees;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public void setParentLibelle(String parentLibelle) {
    this.parentLibelle = parentLibelle;
  }

  public String getParentLibelle() {
    return parentLibelle;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getParentDesciption() {
    return parentDesciption;
  }

  public void setParentDesciption(String parentDesciption) {
    this.parentDesciption = parentDesciption;
  }
}
