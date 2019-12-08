package org.codedivoire.core.subdomains.usermanagement.application.command;

import java.time.LocalDate;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.UserProfile.Civility;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.UserProfile.Gender;
import org.codedivoire.core.subdomains.usermanagement.domain.valueobject.Address;

/**
 * Commande pour la modification d'un profile utilisateur
 *
 * @author Christian Amani 2019-12-08
 */
public class UpdateUserProfileCommand {

  @NotNull
  private UUID id;
  private Address address;
  private String logoUrl;
  @NotNull
  private String lastName;
  private String firstName;
  private LocalDate birthDate;
  private Gender gender;
  private Civility civility;
  private String function;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
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
}
