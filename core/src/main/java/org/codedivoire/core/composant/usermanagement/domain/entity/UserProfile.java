package org.codedivoire.core.composant.usermanagement.domain.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Christian Amani 2019-11-24
 */
public class UserProfile extends Profile {

  private String lastName;
  private String firstName;
  private LocalDate birthDate;
  private Gender gender;
  private Civility civility;
  private String function;

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

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), lastName, firstName, birthDate, gender, civility, function);
  }

  public enum Gender {
    MASCULIN,
    FEMININ
  }

  public enum Civility {
    MADAME,
    MADEMOISELLE,
    MONSIEUR
  }
}
