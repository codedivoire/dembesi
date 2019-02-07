package org.codedivoire.dembesi.common.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.stereotype.Component;

/**
 * @author Christian Amani on 07/02/2019.
 */
@Component
public class ServerAuthorisationRegistration implements ClientRegistrationRepository {

    private final Logger LOG = LoggerFactory.getLogger(ServerAuthorisationRegistration.class);

    @Override
    public ClientRegistration findByRegistrationId(String s) {
        LOG.debug("Debut du Process 'findByRegistrationId'");
        if(s.equalsIgnoreCase("facebook")) {
            ClientRegistration.withRegistrationId(s)
                    .clientId("315076625809519")
                    .clientSecret("614d1aa22dab48e551e3b83bb48c1362")
                    .tokenUri("https://graph.facebook.com/oauth/access_token")
                    .authorizationUri("https://www.facebook.com/dialog/oauth")
                    .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                    .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                    .userInfoUri("https://graph.facebook.com/me")
                    .build();
        }
        return null;
    }
}
