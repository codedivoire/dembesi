package org.codedivoire.core.subdomains.usermanagement.application.usecase.user;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.codedivoire.core.kernelshared.application.exception.InformationNotFound;
import org.codedivoire.core.subdomains.usermanagement.application.port.RepositoryUserPort;
import org.codedivoire.core.subdomains.usermanagement.domain.entity.User;
import org.codedivoire.core.subdomains.usermanagement.domain.exception.UserLocked;
import org.codedivoire.core.subdomains.usermanagement.domain.exception.UserNotActivated;
import org.codedivoire.core.subdomains.usermanagement.domain.exception.UserPasswordExpired;

/**
 * Cas d'utilisation pour l'authentification d'un utilisateur
 *
 * @author Christian Amani 2019-12-08
 */
public class AuthenticateUser {

  private static final int CHANGE_WORD_CHANGE_TIME_IN_DAY = 90;

  private final RepositoryUserPort repositoryUserPort;

  public AuthenticateUser(
      RepositoryUserPort repositoryUserPort) {
    this.repositoryUserPort = repositoryUserPort;
  }

  public void authenticate(String login) {
    User user = repositoryUserPort.findByLogin(login);
    if (user == null) {
      throw new InformationNotFound();
    }
    boolean active = user.isActive();
    if (!active) {
      throw new UserNotActivated();
    }
    boolean isLock = user.isLock();
    if (isLock) {
      throw new UserLocked();
    }
    Instant theLastChangeDatePassword = user.getTheLastChangeDatePassword();
    Instant maintenant = Instant.now(Clock.systemUTC());
    Instant expire = maintenant.minus(CHANGE_WORD_CHANGE_TIME_IN_DAY, ChronoUnit.DAYS);
    boolean viensApres = expire.isAfter(theLastChangeDatePassword);
    if (viensApres) {
      throw new UserPasswordExpired();
    }
  }
}
