package org.codedivoire.core.kernelshared;

/**
 * Gestionnaire de base des commandes
 *
 * @author Christian Amani 2019-11-24
 */
public interface CommandManager<C> {

  void executed(C command);
}
