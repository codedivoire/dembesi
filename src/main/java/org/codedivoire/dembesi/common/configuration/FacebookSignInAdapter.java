package org.codedivoire.dembesi.common.configuration;

import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.codedivoire.dembesi.usermanagement.entity.Role;
import org.codedivoire.dembesi.usermanagement.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.*;

/**
 * Created by Christian Amani on 09/02/2019.
 */
@Component
public class FacebookSignInAdapter implements SignInAdapter {

    private final ProfileRepository profileRepository;

    @Autowired
    public FacebookSignInAdapter(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest nativeWebRequest) {
        Optional<Profile> optionalProfile = profileRepository.findByUsername(userId);
        List<Role> roles = new ArrayList<>();
        if (optionalProfile.isPresent()) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userId, null
                    , roles));
        } else {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userId, null
                    , Collections.singletonList(new SimpleGrantedAuthority("FACEBOOK_USER"))));
        }
        return null;
    }
}
