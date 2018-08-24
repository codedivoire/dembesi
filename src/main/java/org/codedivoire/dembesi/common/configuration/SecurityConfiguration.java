package org.codedivoire.dembesi.common.configuration;

import org.codedivoire.dembesi.common.service.impl.AccountDetailsService;
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

/**
 * @author Christian Amani on 24/08/2018.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private Logger LOG = LoggerFactory.getLogger(SecurityConfiguration.class);

    private final AccountDetailsService accountDetailsService;

    private final AccountAuthenticationSuccessHandler accountAuthenticationSuccessHandler;

    private final AccountLogoutSuccessHandler accountLogoutSuccessHandler;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public SecurityConfiguration(AccountDetailsService accountDetailsService
            , AccountAuthenticationSuccessHandler accountAuthenticationSuccessHandler
            , AccountLogoutSuccessHandler accountLogoutSuccessHandler, PasswordEncoder passwordEncoder) {
        this.accountDetailsService = accountDetailsService;
        this.accountAuthenticationSuccessHandler = accountAuthenticationSuccessHandler;
        this.accountLogoutSuccessHandler = accountLogoutSuccessHandler;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(accountDetailsService);
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                .logoutSuccessHandler(accountLogoutSuccessHandler)
                .and()
                .formLogin()
                .successHandler(accountAuthenticationSuccessHandler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

}
