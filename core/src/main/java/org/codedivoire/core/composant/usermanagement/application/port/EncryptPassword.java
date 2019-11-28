package org.codedivoire.core.composant.usermanagement.application.port;

/**
 * @author Christian Amani 2019-11-24
 */
public interface EncryptPassword {

  String encrypte(String motPasse);

  boolean correspond(String motPasse, String motPasseCrypte);
}
