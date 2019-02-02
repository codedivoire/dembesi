package org.codedivoire.dembesi.usermanagement.service;

import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Christian Amani on 17/01/2019.
 */
public interface ProfileService extends UserDetailsService {

    Profile save(Profile profile);

    Profile find(long id);

    Profile find(String email);
}
