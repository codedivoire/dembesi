package org.codedivoire.core.composant.usermanagement.application.command;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.codedivoire.core.composant.usermanagement.domain.entity.UserProfile;
import org.codedivoire.core.composant.usermanagement.domain.entity.UserProfile.Civility;
import org.codedivoire.core.composant.usermanagement.domain.entity.UserProfile.Gender;
import org.codedivoire.core.composant.usermanagement.domain.valueobject.Address;

/**
 * Commande pour la création d'un nouveau utilisateur physique
 *
 * @author Christian Amani 2019-10-25
 */
public class CreateUserCommand {

  @NotBlank
  @Size(min = 8, max = 100)
  private String login;
  @NotBlank
  @Size(min = 8, max = 100)
  private String password;
  @Email
  private String email;
  private String firstName;
  @NotBlank
  private String lastName;
  @NotNull
  private LocalDate birthDate;
  @NotNull
  private UserProfile.Gender gender;
  @NotNull
  private UserProfile.Civility civility;
  private String function;
  @NotNull
  private Address address;
  @NotBlank
  private String userGroup;
  private List<String> permissionsId;
  private String urlLogo;


  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(
      Gender gender) {
    this.gender = gender;
  }

  public Civility getCivility() {
    return civility;
  }

  public void setCivility(
      Civility civility) {
    this.civility = civility;
  }

  public String getFunction() {
    return function;
  }

  public void setFunction(String function) {
    this.function = function;
  }

  public Address getAddress() {
    return address;
  }

  public void setAdresse(
      Address address) {
    this.address = address;
  }


  public String getUrlLogo() {
    return urlLogo;
  }

  public void setUrlLogo(String logoUrl) {
    this.urlLogo = logoUrl;
  }

  public String getUserGroup() {
    return userGroup;
  }

  public void setUserGroup(String userGroup) {
    this.userGroup = userGroup;
  }

  public List<String> getPermissionsId() {
    return permissionsId;
  }

  public void setPermissionsId(List<String> permissionsId) {
    this.permissionsId = permissionsId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
