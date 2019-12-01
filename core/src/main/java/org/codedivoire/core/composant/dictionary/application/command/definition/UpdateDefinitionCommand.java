package org.codedivoire.core.composant.dictionary.application.command.definition;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.composant.dictionary.domain.entity.Definition;
import org.codedivoire.core.composant.dictionary.domain.valueobject.State;

/**
 * Command for updating a definition of {@link Definition}
 *
 * @author Christian Amani 2019-12-01
 */
public class UpdateDefinitionCommand extends CreateDefinitionCommand {

  @NotNull
  private UUID id;
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
