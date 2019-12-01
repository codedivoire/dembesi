package org.codedivoire.core.composant.dictionary.application.command.diction;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.composant.dictionary.domain.entity.Diction;
import org.codedivoire.core.composant.dictionary.domain.valueobject.State;

/**
 * Command for updating a definition of {@link Diction}
 *
 * @author Christian Amani 2019-12-01
 */
public class UpdateDictionCommand extends CreateDictionCommand {

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
