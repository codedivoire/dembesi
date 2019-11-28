package org.codedivoire.core.composant.usermanagement.domaine.valueobject;

/**
 * Objet valeur pour une adresse
 *
 * @author Christian Amani 2019-11-24
 */
public class Address {

  private String adressePostale;
  private String adresseGeographique;
  private String telephone1;
  private String telephone2;
  private String email;
  private String emailSecondaire;
  private String fax;
  private String webSite;
  private String boitePostale;

  public String getAdressePostale() {
    return adressePostale;
  }

  public void setAdressePostale(String adressePostale) {
    this.adressePostale = adressePostale;
  }

  public String getAdresseGeographique() {
    return adresseGeographique;
  }

  public void setAdresseGeographique(String adresseGeographique) {
    this.adresseGeographique = adresseGeographique;
  }

  public String getTelephone1() {
    return telephone1;
  }

  public void setTelephone1(String telephone1) {
    this.telephone1 = telephone1;
  }

  public String getTelephone2() {
    return telephone2;
  }

  public void setTelephone2(String telephone2) {
    this.telephone2 = telephone2;
  }

  public String getWebSite() {
    return webSite;
  }

  public void setWebSite(String webSite) {
    this.webSite = webSite;
  }

  public String getBoitePostale() {
    return boitePostale;
  }

  public void setBoitePostale(String boitePostale) {
    this.boitePostale = boitePostale;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmailSecondaire() {
    return emailSecondaire;
  }

  public void setEmailSecondaire(String emailSecondaire) {
    this.emailSecondaire = emailSecondaire;
  }
}
