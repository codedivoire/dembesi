package org.codedivoire.core.composant.usermanagement.application.port;


import org.codedivoire.core.composant.usermanagement.domaine.entity.HistoryPassword;
import org.codedivoire.core.composant.usermanagement.domaine.entity.User;

/**
 * Port du repository de l'entité {@link HistoryPassword}
 *
 * @author Christian Amani 2019-11-24
 */
public interface HistoryPasswordRepositoryPort {

  void enregistrer(HistoryPassword historyPassword,
      User user);
}
