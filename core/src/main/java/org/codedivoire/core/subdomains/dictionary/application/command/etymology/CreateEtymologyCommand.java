package org.codedivoire.core.subdomains.dictionary.application.command.etymology;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Etymology;

/**
 * Command for creating a new {@link Etymology}
 *
 * @author Christian Amani 2019-12-01
 */
public class CreateEtymologyCommand {

  @NotNull
  private UUID idName;
  @NotBlank
  private String origin;
  private String originEnglishTranslate;

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getOriginEnglishTranslate() {
    return originEnglishTranslate;
  }

  public void setOriginEnglishTranslate(String originEnglishTranslate) {
    this.originEnglishTranslate = originEnglishTranslate;
  }

  public UUID getIdName() {
    return idName;
  }

  public void setIdName(UUID idName) {
    this.idName = idName;
  }
}
