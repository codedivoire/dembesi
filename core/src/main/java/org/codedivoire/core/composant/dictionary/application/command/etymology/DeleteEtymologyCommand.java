package org.codedivoire.core.composant.dictionary.application.command.etymology;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.composant.dictionary.domain.entity.Etymology;

/**
 * Command for deletetion a {@link Etymology}
 *
 * @author Christian Amani 2019-12-01
 */
public class DeleteEtymologyCommand {

  @NotNull
  private UUID idName;
  @NotNull
  private UUID idEtymology;

  public UUID getIdName() {
    return idName;
  }

  public void setIdName(UUID idName) {
    this.idName = idName;
  }

  public UUID getIdEtymology() {
    return idEtymology;
  }

  public void setIdEtymology(UUID idEtymology) {
    this.idEtymology = idEtymology;
  }
}
