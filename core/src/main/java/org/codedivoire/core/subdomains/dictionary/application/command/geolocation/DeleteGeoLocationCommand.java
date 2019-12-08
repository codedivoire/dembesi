package org.codedivoire.core.subdomains.dictionary.application.command.geolocation;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.subdomains.dictionary.domain.entity.GeoLocation;

/**
 * Command for deletetion a {@link GeoLocation}
 *
 * @author Christian Amani 2019-12-01
 */
public class DeleteGeoLocationCommand {

  @NotNull
  private UUID idName;
  @NotNull
  private UUID idGeoLocation;

  public UUID getIdName() {
    return idName;
  }

  public void setIdName(UUID idName) {
    this.idName = idName;
  }

  public UUID getIdGeoLocation() {
    return idGeoLocation;
  }

  public void setIdGeoLocation(UUID idGeoLocation) {
    this.idGeoLocation = idGeoLocation;
  }
}
