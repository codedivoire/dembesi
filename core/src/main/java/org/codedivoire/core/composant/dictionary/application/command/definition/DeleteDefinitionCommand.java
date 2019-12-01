package org.codedivoire.core.composant.dictionary.application.command.definition;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.composant.dictionary.domain.entity.Definition;

/**
 * Command for deletetion a {@link Definition}
 *
 * @author Christian Amani 2019-12-01
 */
public class DeleteDefinitionCommand {

  @NotNull
  private UUID idDefinition;
  @NotNull
  private UUID idName;

  public UUID getIdDefinition() {
    return idDefinition;
  }

  public void setIdDefinition(UUID idDefinition) {
    this.idDefinition = idDefinition;
  }

  public UUID getIdName() {
    return idName;
  }

  public void setIdName(UUID idName) {
    this.idName = idName;
  }
}
