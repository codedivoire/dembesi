package org.codedivoire.core.composant.dictionary.application.command.geolocation;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.composant.dictionary.domain.entity.GeoLocation;
import org.codedivoire.core.composant.dictionary.domain.valueobject.State;

/**
 * Command for updating a {@link GeoLocation}
 *
 * @author Christian Amani 2019-12-01
 */
public class UpdateGeoLocationCommand extends CreateGeoLocationCommand {

  @NotNull
  private UUID id;
  @NotNull
  private State state;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }
}
