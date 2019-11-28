package org.codedivoire.core.composant.usermanagement.application.port;


import java.util.List;
import org.codedivoire.core.composant.usermanagement.domaine.entity.Permission;

/**
 * Port du repository de l'entité {@link Permission}
 *
 * @author Christian Amani 2019-11-24
 */
public interface PermissionRepositoryPort {

  Permission rechercherParLibelle(String libelle);

  List<Permission> rechercherParentSuperieur();

  List<Permission> rechercherParParent(Permission permissionTable);
}
