package org.codedivoire.core.subdomains.dictionary.application.command.diction;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.codedivoire.core.subdomains.dictionary.domain.entity.Diction;

/**
 * Command for creating a new {@link Diction}
 *
 * @author Christian Amani 2019-12-01
 */
public class CreateDictionCommand {

  @NotNull
  private UUID idName;
  @NotBlank
  private String pronunciation;
  private String uriAudio;

  public String getPronunciation() {
    return pronunciation;
  }

  public void setPronunciation(String pronunciation) {
    this.pronunciation = pronunciation;
  }

  public String getUriAudio() {
    return uriAudio;
  }

  public void setUriAudio(String uriAudio) {
    this.uriAudio = uriAudio;
  }

  public UUID getIdName() {
    return idName;
  }

  public void setIdName(UUID idName) {
    this.idName = idName;
  }
}
