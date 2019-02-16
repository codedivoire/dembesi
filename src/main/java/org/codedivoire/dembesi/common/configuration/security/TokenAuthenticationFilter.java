package org.codedivoire.dembesi.common.configuration.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.codedivoire.dembesi.common.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Christian Amani on 14/02/2019.
 */
@Component
public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final Logger LOG = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

    private final TokenService tokenService;
    private final AuthenticationManagerBuilder authenticationManager;

    @Autowired
    public TokenAuthenticationFilter(TokenService tokenService, AuthenticationManagerBuilder authenticationManager) {
        super(new AntPathRequestMatcher("/api/**"));
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        LOG.debug("Debut du Process 'attemptAuthentication'");
        String headerAuthorisation = httpServletRequest.getHeader("Authorization");
        if (headerAuthorisation == null || !headerAuthorisation.startsWith("Bearer ")) {
            LOG.info("Not Found header Authorization param");
            throw new InsufficientAuthenticationException("Not Found header Authorization");
        } else {
            String token = headerAuthorisation.substring(7);
            if (tokenService.tokenIsValid(token)) {
                DecodedJWT jwt = tokenService.getJwt(token);
                String username = jwt.getSubject();
                String password = jwt.getClaim("password").asString();
                UsernamePasswordAuthenticationToken authenticationToken
                        = new UsernamePasswordAuthenticationToken(username, password);
                authenticationToken.setAuthenticated(true);
                return authenticationToken;
            }
            throw new UsernameNotFoundException("Username Not Found");
        }
    }

    @Autowired
    @Override
    public void setAuthenticationManager(@Lazy AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}
