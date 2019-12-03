package org.codedivoire.core.composant.usermanagement.domain.valueobject;

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
  private String label;
  private String description;
  private String labelParent;
  private String descriptionParent;
  private List<PermissionTree> childs = new ArrayList<>();

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public List<PermissionTree> getChilds() {
    return childs;
  }

  public void setChilds(
      List<PermissionTree> permissionTrees) {
    this.childs = permissionTrees;
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

  public void setLabelParent(String labelParent) {
    this.labelParent = labelParent;
  }

  public String getLabelParent() {
    return labelParent;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescriptionParent() {
    return descriptionParent;
  }

  public void setDescriptionParent(String descriptionParent) {
    this.descriptionParent = descriptionParent;
  }
}
