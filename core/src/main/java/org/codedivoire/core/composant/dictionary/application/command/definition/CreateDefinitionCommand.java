package org.codedivoire.core.composant.dictionary.application.command.definition;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.composant.dictionary.domain.entity.Definition;

/**
 * Command for creating a new definition of {@link Definition}
 *
 * @author Christian Amani 2019-12-01
 */
public class CreateDefinitionCommand {

  @NotNull
  private UUID idName;
  @NotBlank
  private String content;
  private String englishContent;
  private String localLanguageContent;

  public UUID getIdName() {
    return idName;
  }

  public void setIdName(UUID idName) {
    this.idName = idName;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getEnglishContent() {
    return englishContent;
  }

  public void setEnglishContent(String englishContent) {
    this.englishContent = englishContent;
  }

  public String getLocalLanguageContent() {
    return localLanguageContent;
  }

  public void setLocalLanguageContent(String localLanguageContent) {
    this.localLanguageContent = localLanguageContent;
  }
}
