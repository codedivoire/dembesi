package org.codedivoire.dembesi.common.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.web.ProviderSignInInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Christian Amani on 12/02/2019.
 */
@Component
public class SocialSignInInterceptor implements ProviderSignInInterceptor {

    private final Logger LOG = LoggerFactory.getLogger(SocialSignInInterceptor.class);

    @Override
    public void preSignIn(ConnectionFactory connectionFactory, MultiValueMap multiValueMap, WebRequest webRequest) {
        LOG.debug("Debut du Process 'preSignIn'");
    }

    @Override
    public void postSignIn(Connection connection, WebRequest webRequest) {
        LOG.debug("Debut du Process 'postSignIn'");
        LOG.info("User"+connection.getDisplayName()+"just signed in via Spring Social ");
    }
}
