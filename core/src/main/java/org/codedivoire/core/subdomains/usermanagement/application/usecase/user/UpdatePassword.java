package org.codedivoire.core.subdomains.usermanagement.application.usecase.user;

import org.codedivoire.core.subdomains.usermanagement.application.command.UpdatePasswordCommand;
import org.codedivoire.core.subdomains.usermanagement.application.exception.NoCorrespondenceCredential;
import org.codedivoire.core.subdomains.usermanagement.application.port.EncryptDataPort;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryHistoryPasswordPort;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryUserPort;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.HistoryPassword;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.User;

/**
 * Cas d'utilisation pour la modification d'un mot de passe et son historisation
 *
 * @author Christian Amani 2019-12-08
 */
public class UpdatePassword {

  private final EncryptDataPort encryptDataPort;
  private final RepositoryUserPort repositoryUserPort;
  private final RepositoryHistoryPasswordPort repositoryHistoryPasswordPort;

  public UpdatePassword(
      EncryptDataPort encryptDataPort,
      RepositoryUserPort repositoryUserPort,
      RepositoryHistoryPasswordPort repositoryHistoryPasswordPort) {
    this.encryptDataPort = encryptDataPort;
    this.repositoryUserPort = repositoryUserPort;
    this.repositoryHistoryPasswordPort = repositoryHistoryPasswordPort;
  }


  public void update(UpdatePasswordCommand command) {
    String login = command.getLogin();
    User user = repositoryUserPort.findByLogin(login);
    String currentPassword = user.getPassword();
    String currentCommandPassword = command.getAncienMotPasse();
    boolean correspond = encryptDataPort.correspond(currentCommandPassword, currentPassword);
    if (correspond) {
      String newPassword = command.getNouveauMotPasse();
      String newWordPasswordCrypt = encryptDataPort.encrypt(newPassword);
      HistoryPassword historyPassword = user.historizePassword(newPassword);
      user.setPassword(newWordPasswordCrypt);
      repositoryHistoryPasswordPort.add(historyPassword, user);
    } else {
      throw new NoCorrespondenceCredential();
    }
  }
}
