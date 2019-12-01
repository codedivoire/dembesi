package org.codedivoire.core.composant.dictionary.application.command.diction;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.composant.dictionary.domain.entity.Diction;

/**
 * Command for deletetion a {@link Diction}
 *
 * @author Christian Amani 2019-12-01
 */
public class DeleteDictionCommand {

  @NotNull
  private UUID idName;
  @NotNull
  private UUID idDiciton;

  public UUID getIdName() {
    return idName;
  }

  public void setIdName(UUID idName) {
    this.idName = idName;
  }

  public UUID getIdDiciton() {
    return idDiciton;
  }

  public void setIdDiciton(UUID idDiciton) {
    this.idDiciton = idDiciton;
  }
}
