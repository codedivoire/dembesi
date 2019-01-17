package org.codedivoire.dembesi.common.configuration;

import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * @author  Christian Amani on 24/08/2018.
 */
@Component
public class AccountLogoutSuccessHandler implements LogoutSuccessHandler,UtilsHandler{

    private final Logger LOG = LoggerFactory.getLogger(AccountLogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        LOG.debug("Début du Process 'onLogoutSuccess'");
        LOG.info("Succès de la déconnexion");
        LOG.info("Remote IP : "+request.getRemoteAddr());
        Profile account = (Profile) authentication.getPrincipal();
        if(account != null) {
            LOG.info("Nom : "+account.getUsername());
            String authorities = getAuthorities(account);
            LOG.info("Privilege : "+authorities);
        }
    }

    @Override
    public String getAuthorities(Profile account) {
        LOG.debug("Début du Process 'getAuthorities'");
        Collection<? extends GrantedAuthority> grantedAuthority = account.getAuthorities();
        return String.join(",", AuthorityUtils.authorityListToSet(grantedAuthority));
    }
}
