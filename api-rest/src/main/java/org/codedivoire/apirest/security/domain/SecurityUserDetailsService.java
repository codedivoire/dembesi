package org.codedivoire.apirest.security.domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service dédié à l'authentification des utilisateurs de l'application
 *
 * @author Christian Amani
 */
@Component("userDetailsService")
public class SecurityUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(SecurityUserDetailsService.class);

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);
        // TODO : Ajouter l'implémentation
        throw new UsernameNotFoundException("Pas encore implémenté");
    }
}
