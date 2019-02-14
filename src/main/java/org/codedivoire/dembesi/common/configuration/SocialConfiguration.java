package org.codedivoire.dembesi.common.configuration;

import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import javax.sql.DataSource;
import java.time.LocalDateTime;

/**
 * @author Christian Amani on 09/02/2019.
 */
@Configuration
@EnableSocial
public class SocialConfiguration implements SocialConfigurer {

    private final DataSource dataSource;

    @Autowired
    public SocialConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment environment) {
        cfConfig.addConnectionFactory(new FacebookConnectionFactory("315076625809519"
                ,"614d1aa22dab48e551e3b83bb48c1362"));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return new JdbcUsersConnectionRepository(dataSource,connectionFactoryLocator, Encryptors.noOpText());
    }

    private class AuthenticationNameUserIdSource implements UserIdSource {
        @Override
        public String getUserId() {
            Profile principal = (Profile) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            return principal.getUserId();
        }
    }
}
