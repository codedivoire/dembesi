package org.codedivoire.core.composant.usermanagement.domain.entity;

import java.util.Objects;
import java.util.UUID;
import org.codedivoire.core.composant.usermanagement.domain.valueobject.Address;

/**
 * Entité abstraite type personne
 *
 * @author Christian Amani 2019-11-24
 */
public class Profile {

  private UUID id;
  private Address address;
  private String logoUrl;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Address getAdresse() {
    return address;
  }

  public void setAddress(
      Address address) {
    this.address = address;
  }

  public void setTelephone1(String telephone) {
    if(address == null) {
      address = new Address();
    }
    address.setPhoneNumber1(telephone);
  }

  public void setEmail(String email) {
    if(address == null) {
      address = new Address();
    }
    address.setEmail(email);
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Profile)) {
      return false;
    }
    Profile profile = (Profile) o;
    return id.equals(profile.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, address, logoUrl);
  }
}
