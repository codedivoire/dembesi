package org.codedivoire.core.composant.dictionary.application.command.name;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.composant.dictionary.domain.entity.Name;
import org.codedivoire.core.composant.dictionary.domain.valueobject.State;

/**
 * Command for updating a new {@link Name}
 *
 * @author Christian Amani 2019-11-26
 */
public class UpdateNameCommand {

  @NotNull
  private UUID id;
  @NotBlank
  private String value;
  @NotNull
  private State state;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }
}
