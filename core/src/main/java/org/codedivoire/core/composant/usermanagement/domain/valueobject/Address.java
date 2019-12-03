package org.codedivoire.core.composant.usermanagement.domain.valueobject;

/**
 * Objet valeur pour une adresse
 *
 * @author Christian Amani 2019-11-24
 */
public class Address {

  private String mailingAddress;
  private String geographicAddress;
  private String phoneNumber1;
  private String phoneNumber2;
  private String email;
  private String secondEmail;
  private String fax;
  private String webSite;

  public String getMailingAddress() {
    return mailingAddress;
  }

  public void setMailingAddress(String mailingAddress) {
    this.mailingAddress = mailingAddress;
  }

  public String getGeographicAddress() {
    return geographicAddress;
  }

  public void setGeographicAddress(String geographicAddress) {
    this.geographicAddress = geographicAddress;
  }

  public String getPhoneNumber1() {
    return phoneNumber1;
  }

  public void setPhoneNumber1(String phoneNumber1) {
    this.phoneNumber1 = phoneNumber1;
  }

  public String getPhoneNumber2() {
    return phoneNumber2;
  }

  public void setPhoneNumber2(String phoneNumber2) {
    this.phoneNumber2 = phoneNumber2;
  }

  public String getWebSite() {
    return webSite;
  }

  public void setWebSite(String webSite) {
    this.webSite = webSite;
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

  public String getSecondEmail() {
    return secondEmail;
  }

  public void setSecondEmail(String secondEmail) {
    this.secondEmail = secondEmail;
  }
}
