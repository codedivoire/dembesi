package org.codedivoire.core.subdomains.dictionary.domain.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * Entité de la localisation, donne les coordonnées géographique d'un nom
 *
 * @author Christian Amani 2019-11-24
 */
public class GeoLocation extends WordDictionary implements Serializable {

  private String region;
  private String localisation;
  private Opinion opinion;
  private Name owner;

  public GeoLocation(String region, String localisation) {
    this.region = region;
    this.localisation = localisation;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getLocalisation() {
    return localisation;
  }

  public void setLocalisation(String localisation) {
    this.localisation = localisation;
  }

  public Name getOwner() {
    return owner;
  }

  public void setOwner(Name owner) {
    this.owner = owner;
  }

  public Opinion getOpinion() {
    return opinion;
  }

  public void setOpinion(Opinion opinion) {
    this.opinion = opinion;
  }

  @Override
  public boolean equals(Object o) {
   return super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), region, localisation, opinion, owner);
  }
}
