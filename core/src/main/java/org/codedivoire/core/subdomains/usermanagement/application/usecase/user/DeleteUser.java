package org.codedivoire.core.subdomains.usermanagement.application.usecase.user;

import java.util.UUID;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryUserPort;

/**
 * Cas d'utilisation pour la suppression/archivage d'un utilisateur
 *
 * @author Christian Amani 2019-12-08
 */
public class DeleteUser {

  private final RepositoryUserPort repositoryUserPort;

  public DeleteUser(
      RepositoryUserPort repositoryUserPort) {
    this.repositoryUserPort = repositoryUserPort;
  }

  public void delete(UUID userId) {
    repositoryUserPort.delete(userId);
  }
}
