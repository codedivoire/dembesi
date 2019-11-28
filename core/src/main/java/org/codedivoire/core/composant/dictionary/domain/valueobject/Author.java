package org.codedivoire.core.composant.dictionary.domain.valueobject;

/**
 * Un autheur est un utilisateur ayant émise une information dans le système
 *
 * @author Christian Amani 2019-11-26
 */
public class Author {

  private String login;
  private String firstName;
  private String lastName;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
