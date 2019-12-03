package org.codedivoire.core.kernelshared;

/**
 * Gestionnaire de requête de base
 *
 * @author Christian Amani 2019-10-22
 */
public interface CommandQuery<REQ, RES> {

  RES query(REQ requete);
}
