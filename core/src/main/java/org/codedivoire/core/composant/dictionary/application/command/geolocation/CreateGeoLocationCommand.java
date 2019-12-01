package org.codedivoire.core.composant.dictionary.application.command.geolocation;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.composant.dictionary.domain.entity.GeoLocation;

/**
 * Command for creating a new {@link GeoLocation}
 *
 * @author Christian Amani 2019-12-01
 */
public class CreateGeoLocationCommand {

  @NotNull
  private UUID idName;
  @NotBlank
  private String region;
  private String localisation;

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

  public UUID getIdName() {
    return idName;
  }

  public void setIdName(UUID idName) {
    this.idName = idName;
  }
}
