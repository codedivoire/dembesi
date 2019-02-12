package org.codedivoire.dembesi.common.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.connect.web.ProviderSignInUtils;

/**
 * @author Christian Amani on 09/02/2019.
 */
@Configuration
public class SocialSignInConfiguration {

    private final ConnectionFactoryLocator connectionFactoryLocator;

    private final UsersConnectionRepository usersConnectionRepository;

    private final FacebookConnectionSignup facebookConnectionSignup;

    private final FacebookSignInAdapter facebookSignInAdapter;

    private final SocialSignInInterceptor socialSignInInterceptor;

    @Autowired
    public SocialSignInConfiguration(ConnectionFactoryLocator connectionFactoryLocator
            , UsersConnectionRepository usersConnectionRepository, FacebookConnectionSignup facebookConnectionSignup
            , FacebookSignInAdapter facebookSignInAdapter, SocialSignInInterceptor socialSignInInterceptor) {
        this.connectionFactoryLocator = connectionFactoryLocator;
        this.usersConnectionRepository = usersConnectionRepository;
        this.facebookConnectionSignup = facebookConnectionSignup;
        this.facebookSignInAdapter = facebookSignInAdapter;
        this.socialSignInInterceptor = socialSignInInterceptor;
    }

    @Bean
    public ProviderSignInController facebookSignInController() {
        ((InMemoryUsersConnectionRepository) usersConnectionRepository).setConnectionSignUp(facebookConnectionSignup);
        ProviderSignInController controller = new ProviderSignInController(connectionFactoryLocator
                , usersConnectionRepository, facebookSignInAdapter);
        controller.addSignInInterceptor(socialSignInInterceptor);
        return controller;
    }

    @Bean
    public ProviderSignInUtils providerSignInUtils() {
        ((InMemoryUsersConnectionRepository) usersConnectionRepository).setConnectionSignUp(facebookConnectionSignup);
        return new ProviderSignInUtils(connectionFactoryLocator,usersConnectionRepository);
    }
}
