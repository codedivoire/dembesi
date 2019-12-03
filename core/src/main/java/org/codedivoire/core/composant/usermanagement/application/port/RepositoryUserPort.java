package org.codedivoire.core.composant.usermanagement.application.port;

import java.util.UUID;
import org.codedivoire.core.composant.usermanagement.domain.entity.User;
import org.codedivoire.core.composant.usermanagement.domain.entity.UserProfile;

/**
 * Port du repository de l'entité {@link User}
 *
 * @author Christian Amani 2019-10-24
 */
public interface RepositoryUserPort {

  User findByLogin(String login);

  User findById(UUID id);

  void add(User user);

  void add(User user, UserProfile personneMorale);

  void delete(UUID id);

  boolean loginExist(String login);
}
