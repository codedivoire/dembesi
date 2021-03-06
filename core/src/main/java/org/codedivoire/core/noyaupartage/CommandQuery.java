package org.codedivoire.core.noyaupartage;

/**
 * Gestionnaire de requête de base
 *
 * @author Christian Amani 2019-10-22
 */
public interface CommandQuery<RES, REQ> {

  RES query(REQ requete);
}
