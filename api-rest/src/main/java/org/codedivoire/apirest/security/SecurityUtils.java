package org.codedivoire.apirest.security;

import java.util.Optional;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Classe d'utilitaire pour Spring Security
 *
 * @author Chrisitian Amani 2019-08-27
 */
public final class SecurityUtils {

  private SecurityUtils() {
  }

  /**
   * Obtien le login de l'utilisateur courant
   *
   * @return le login de l'utilisateur connecté
   */
  public static Optional<String> getCurrentUserLogin() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    return Optional.ofNullable(securityContext.getAuthentication())
        .map(authentication -> {
          if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
            return springSecurityUser.getUsername();
          } else if (authentication.getPrincipal() instanceof String) {
            return (String) authentication.getPrincipal();
          }
          return null;
        });
  }

  /**
   * Obtien le Token (JWT) de l'utilisateur courant
   *
   * @return le token (JWT) de l'utilisateur courant
   */
  public static Optional<String> getCurrentUserJWT() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    return Optional.ofNullable(securityContext.getAuthentication())
        .filter(authentication -> authentication.getCredentials() instanceof String)
        .map(authentication -> (String) authentication.getCredentials());
  }

  /**
   * Vérifier si l'utilisateur est authentifié
   *
   * @return true if the user is authenticated, false otherwise.
   */
  public static boolean isAuthenticated() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    return Optional.ofNullable(securityContext.getAuthentication())
        .map(authentication -> authentication.getAuthorities().stream()
            .noneMatch(grantedAuthority -> grantedAuthority.getAuthority()
                .equals(AuthoritiesConstants.ANONYMOUS)))
        .orElse(false);
  }

  /**
   * Vérifie si l'utilisateur courant possède une habilitation
   * <p>
   * Le nom de cette méthode vient de la méthode {@code isUserInRole()} de l'API Servlet.
   *
   * @param authority l'habilitation à vérifier
   * @return Vrai si l'utilisateur courant possède l'habilitation, faut sinon
   */
  public static boolean isCurrentUserInRole(String authority) {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    return Optional.ofNullable(securityContext.getAuthentication())
        .map(authentication -> authentication.getAuthorities().stream()
            .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(authority)))
        .orElse(false);
  }
}
