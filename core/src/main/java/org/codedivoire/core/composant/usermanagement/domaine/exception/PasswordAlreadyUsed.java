package org.codedivoire.core.composant.usermanagement.domaine.exception;

/**
 * Se déclenche lorsqu'un mot passe a été précedement utilisé
 *
 * @author Christian Amani 2019-11-24
 */
public class PasswordAlreadyUsed extends RuntimeException {

  public PasswordAlreadyUsed() {
    super();
  }

}
