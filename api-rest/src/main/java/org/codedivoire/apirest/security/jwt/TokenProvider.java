package org.codedivoire.apirest.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import org.codedivoire.apirest.config.properties.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Classe fournissant les ressources pour la manipulation d'un Jeton JWT
 *
 * @author Christian Amani
 */
@Component
public class TokenProvider implements InitializingBean {

  private final Logger log = LoggerFactory.getLogger(TokenProvider.class);

  private static final String AUTHORITIES_KEY = "auth";

  private Key key;

  private long tokenValidityInMilliseconds;

  private long tokenValidityInMillisecondsForRememberMe;

  private final ApplicationProperties applicationProperties;

  public TokenProvider(ApplicationProperties applicationProperties) {
    this.applicationProperties = applicationProperties;
  }

  @Override
  public void afterPropertiesSet() {
    byte[] keyBytes;
    String secret = applicationProperties.getSecurity().getAuthentication().getJwt().getSecret();
    if (!StringUtils.isEmpty(secret)) {
      log.warn("Warning: Le jeton JWT n'est pas encodé en Base64. " +
          "Nous vous recommandons d'utiliser la clé secrète `jhipster.security.authentication.jwt.base64-secret` "
          + "pour une sécurité optimale..");
      keyBytes = secret.getBytes(StandardCharsets.UTF_8);
    } else {
      log.debug("Using a Base64-encoded JWT secret key");
      keyBytes = Decoders.BASE64.decode(
          applicationProperties.getSecurity().getAuthentication().getJwt().getBase64Secret());
    }
    this.key = Keys.hmacShaKeyFor(keyBytes);
    this.tokenValidityInMilliseconds =
        1000 * applicationProperties.getSecurity().getAuthentication().getJwt()
            .getTokenValidityInSeconds();
    this.tokenValidityInMillisecondsForRememberMe =
        1000 * applicationProperties.getSecurity().getAuthentication().getJwt()
            .getTokenValidityInSecondsForRememberMe();
  }

  public String createToken(Authentication authentication, boolean rememberMe) {
    String authorities = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));

    long now = (new Date()).getTime();
    Date validity;
    if (rememberMe) {
      validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
    } else {
      validity = new Date(now + this.tokenValidityInMilliseconds);
    }

    return Jwts.builder()
        .setSubject(authentication.getName())
        .claim(AUTHORITIES_KEY, authorities)
        .signWith(key, SignatureAlgorithm.HS512)
        .setExpiration(validity)
        .compact();
  }

  public Authentication getAuthentication(String token) {
    Claims claims = Jwts.parser()
        .setSigningKey(key)
        .parseClaimsJws(token)
        .getBody();

    Collection<? extends GrantedAuthority> authorities =
        Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

    User principal = new User(claims.getSubject(), "", authorities);

    return new UsernamePasswordAuthenticationToken(principal, token, authorities);
  }

  public boolean validateToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);
      return true;
    } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
      log.info("Signature JWT invalide.");
      log.trace("Signature JWT invalide trace: {}", e);
    } catch (ExpiredJwtException e) {
      log.info("Jeton JWT expiré.");
      log.trace("Jeton JWT expiré trace: {}", e);
    } catch (UnsupportedJwtException e) {
      log.info("Jeton JWT non pris en charge.");
      log.trace("Jeton JWT non pris en charge trace: {}", e);
    } catch (IllegalArgumentException e) {
      log.info("Jeton JWT invalide.");
      log.trace("Jeton JWT invalide trace: {}", e);
    }
    return false;
  }
}
