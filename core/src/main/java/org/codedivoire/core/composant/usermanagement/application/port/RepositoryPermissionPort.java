package org.codedivoire.core.composant.usermanagement.application.port;


import java.util.List;
import org.codedivoire.core.composant.usermanagement.domain.entity.Permission;

/**
 * Port du repository de l'entité {@link Permission}
 *
 * @author Christian Amani 2019-11-24
 */
public interface RepositoryPermissionPort {

  Permission find(String label);

  List<Permission> findSuperiorParent();

  List<Permission> findByParentPermission(Permission permissionTable);
}
