package org.codedivoire.dembesi.usermanagement.service;

import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.codedivoire.dembesi.usermanagement.entity.User;
import org.codedivoire.dembesi.usermanagement.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Christian Amani on 17/01/2019.
 */
@Service
public class UserManagementService implements ProfileService {

    private final Logger LOG = LoggerFactory.getLogger(UserManagementService.class);

    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserManagementService(ProfileRepository profileRepository, PasswordEncoder passwordEncoder) {
        this.profileRepository = profileRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public String encodePassword(String rawPassword) {
        LOG.debug("Debut du Process 'encodePassword'");
        return passwordEncoder.encode(rawPassword);
    }

    public boolean matchPassword(String rawPassword, String passwordEncoded) {
        LOG.debug("Debut du Process 'matchPassword'");
        return passwordEncoder.matches(rawPassword,passwordEncoded);
    }

    @Override
    public Profile save(Profile profile) {
        LOG.debug("Debut du Process 'save'");
        return profileRepository.save(profile);
    }

    @Transactional(readOnly = true)
    @Override
    public Profile find(long id) {
        LOG.debug("Debut du Process 'find'");
        return profileRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Profile find(String email) {
        LOG.debug("Debut du Process 'find'");
        Optional<Profile> optionalProfile = profileRepository.findByEmail(email);
        return optionalProfile.orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.debug("Debut du Proces 'loadUserByUsername'");
        if (username != null) {
            Optional<Profile> optionalProfile = profileRepository.findByUsername(username);
            if (optionalProfile.isPresent())
                return optionalProfile.get();
            throw new UsernameNotFoundException("Profile is not exist");
        } else
            throw new UsernameNotFoundException("Profile is null");
    }
}
