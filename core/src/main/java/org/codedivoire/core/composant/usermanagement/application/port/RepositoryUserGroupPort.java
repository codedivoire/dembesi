package org.codedivoire.core.composant.usermanagement.application.port;

import java.util.List;
import java.util.UUID;
import org.codedivoire.core.composant.usermanagement.domain.entity.UserGroup;

/**
 * Port du repository de l'entité {@link UserGroup}
 *
 * @author Christian Amani 2019-11-24
 */
public interface RepositoryUserGroupPort {

  void add(UserGroup userGroup);

  List<UserGroup> findAll();

  UserGroup find(UUID id);

  UserGroup find(String label);

  void delete(UUID id);
}

