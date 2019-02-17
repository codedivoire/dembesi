package org.codedivoire.dembesi.common.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.codedivoire.dembesi.usermanagement.entity.User;
import org.codedivoire.dembesi.usermanagement.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author Christian Amani on 14/02/2019.
 */
@Service
public class TokenService {

    private final Logger LOG = LoggerFactory.getLogger(TokenService.class);

    private final PasswordEncoder passwordEncoder;
    private final UserManagementService userManagementService;

    @Value("${dembesi.tokenaccess.secret}")
    private String secret;

    public TokenService(PasswordEncoder passwordEncoder, UserManagementService userManagementService) {
        this.passwordEncoder = passwordEncoder;
        this.userManagementService = userManagementService;
    }

    public String createTokenAccess(String email, String password) {
        LOG.debug("Debut du Process 'createTokenAccess'");
        Profile profile = userManagementService.find(email);
        if (profile != null) {
            String encodedPassword = profile.getPassword();
            boolean matched = passwordEncoder.matches(password, encodedPassword);
            if (matched) {
                LocalDateTime expiatedDate = LocalDateTime.now().plusHours(2);
                Algorithm algorithm = Algorithm.HMAC256(secret);
                String token = JWT.create()
                        .withSubject(email)
                        .withClaim("password", password)
                        .withExpiresAt(Date.from(expiatedDate.toInstant(ZoneOffset.UTC)))
                        .sign(algorithm);
                profile.setResetToken(token);
                profile.setResetTokenExpiation(expiatedDate);
                userManagementService.save(profile);
                return token;
            }
        }
        return null;
    }

    public boolean tokenIsValid(String token) {
        LOG.debug("Debut du Process 'tokenIsValid'");
        try {
            DecodedJWT jwt = JWT.decode(token);
            String username = jwt.getSubject();
            Profile profile = userManagementService.find(username);
            if (profile != null) {
                Claim password = jwt.getClaim("password");
                String encodedPassword = profile.getPassword();
                return passwordEncoder.matches(encodedPassword, password.asString());
            }
        } catch (JWTDecodeException ex) {
            ex.printStackTrace();
            LOG.error(ex.getMessage());
            return false;
        }
        return false;
    }

    public DecodedJWT getJwt(String token) {
        LOG.debug("Debut du Process 'getJwt'");
        try {
            return JWT.decode(token);
        } catch (JWTDecodeException ex) {
            ex.printStackTrace();
            LOG.error(ex.getMessage());
            return null;
        }
    }
}
