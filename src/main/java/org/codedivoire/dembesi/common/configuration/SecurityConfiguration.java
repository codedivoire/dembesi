package org.codedivoire.dembesi.common.configuration;

import org.codedivoire.dembesi.usermanagement.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;


/**
 * @author Christian Amani on 24/08/2018.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserManagementService userManagementService;

    private final AccountAuthenticationSuccessHandler accountAuthenticationSuccessHandler;

    private final AccountLogoutSuccessHandler accountLogoutSuccessHandler;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public SecurityConfiguration(UserManagementService userManagementService
            , AccountAuthenticationSuccessHandler accountAuthenticationSuccessHandler
            , AccountLogoutSuccessHandler accountLogoutSuccessHandler, PasswordEncoder passwordEncoder) {
        this.userManagementService = userManagementService;
        this.accountAuthenticationSuccessHandler = accountAuthenticationSuccessHandler;
        this.accountLogoutSuccessHandler = accountLogoutSuccessHandler;
        this.passwordEncoder = passwordEncoder;
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
                .loginPage("/login").permitAll()
                .successHandler(accountAuthenticationSuccessHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/login*","/signin/**","/signup/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .rememberMe()
                .and()
                .apply(new SpringSocialConfigurer());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

}
