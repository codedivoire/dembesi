package org.codedivoire.dembesi.common.configuration;

import org.codedivoire.dembesi.usermanagement.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;


/**
 * @author Christian Amani on 24/08/2018.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private Logger LOG = LoggerFactory.getLogger(SecurityConfiguration.class);

    private final UserManagementService userManagementService;

    private final AccountAuthenticationSuccessHandler accountAuthenticationSuccessHandler;

    private final AccountLogoutSuccessHandler accountLogoutSuccessHandler;

    private final PasswordEncoder passwordEncoder;

    private final ServerAuthorisationRegistration clientRegistration;

    @Autowired
    public SecurityConfiguration(UserManagementService userManagementService
            , AccountAuthenticationSuccessHandler accountAuthenticationSuccessHandler
            , AccountLogoutSuccessHandler accountLogoutSuccessHandler, PasswordEncoder passwordEncoder, ServerAuthorisationRegistration clientRegistration) {
        this.userManagementService = userManagementService;
        this.accountAuthenticationSuccessHandler = accountAuthenticationSuccessHandler;
        this.accountLogoutSuccessHandler = accountLogoutSuccessHandler;
        this.passwordEncoder = passwordEncoder;
        this.clientRegistration = clientRegistration;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userManagementService);
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                .logoutSuccessHandler(accountLogoutSuccessHandler)
                .and()
                .formLogin()
                .successHandler(accountAuthenticationSuccessHandler)
                .and()
                .oauth2Login()
                .clientRegistrationRepository(clientRegistration)
                .authorizedClientService(new InMemoryOAuth2AuthorizedClientService(clientRegistration))
                .userInfoEndpoint()
                .userService(userManagementService);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

}
