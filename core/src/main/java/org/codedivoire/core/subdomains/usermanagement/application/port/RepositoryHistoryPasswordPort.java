package org.codedivoire.core.subdomains.usermanagement.application.port;


import org.codedivoire.core.subdomains.usermanagement.domain.entity.HistoryPassword;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.User;

/**
 * Port du repository de l'entité {@link HistoryPassword}
 *
 * @author Christian Amani 2019-11-24
 */
public interface RepositoryHistoryPasswordPort {

  void add(HistoryPassword historyPassword,
      User user);
}
