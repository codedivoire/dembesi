package org.codedivoire.core.composant.usermanagement.application.command;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.codedivoire.core.composant.usermanagement.domaine.entity.ProfilePhysique;
import org.codedivoire.core.composant.usermanagement.domaine.entity.ProfilePhysique.Civility;
import org.codedivoire.core.composant.usermanagement.domaine.entity.ProfilePhysique.Gender;
import org.codedivoire.core.composant.usermanagement.domaine.valueobject.Address;
import org.codedivoire.core.noyaupartage.Constants;

/**
 * Commande pour la création d'un nouveau utilisateur physique
 *
 * @author Christian Amani 2019-10-25
 */
public class CreerUserCommand {

  private String login;
  @NotBlank
  @Size(min = 8, max = 100)
  @Pattern(regexp = Constants.REGEX_MOT_PASSE)
  private String password;
  @NotBlank
  private String nom;
  @NotBlank
  private String prenom;
  @NotNull
  private LocalDate dateNaissance;
  @NotNull
  private ProfilePhysique.Gender gender;
  @NotNull
  private ProfilePhysique.Civility civility;
  @NotBlank
  private String fonction;
  @NotNull
  private Address address;
  @NotEmpty
  private List<String> groupesUtilisateursId;
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

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public LocalDate getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(LocalDate dateNaissance) {
    this.dateNaissance = dateNaissance;
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

  public String getFonction() {
    return fonction;
  }

  public void setFonction(String fonction) {
    this.fonction = fonction;
  }

  public Address getAdresse() {
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

  public List<String> getGroupesUtilisateursId() {
    return groupesUtilisateursId;
  }

  public void setGroupesUtilisateursId(List<String> groupesUtilisateursId) {
    this.groupesUtilisateursId = groupesUtilisateursId;
  }
}
