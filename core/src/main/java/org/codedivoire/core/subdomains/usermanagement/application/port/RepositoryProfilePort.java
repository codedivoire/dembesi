package org.codedivoire.core.subdomains.usermanagement.application.port;

import org.codedivoire.core.subdomains.usermanagement.domain.entity.Profile;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.UserProfile;

/**
 * Port du repository de l'entité {@link Profile}
 *
 * @author Christian Amani 2019-12-08
 */
public interface RepositoryProfilePort {

  void add(UserProfile userProfile);
}
