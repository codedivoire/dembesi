package org.codedivoire.dembesi.usermanagement.service;

import org.codedivoire.dembesi.usermanagement.entity.Group;
import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.codedivoire.dembesi.usermanagement.entity.User;
import org.codedivoire.dembesi.usermanagement.repository.GroupRepository;
import org.codedivoire.dembesi.usermanagement.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Christian Amani on 17/01/2019.
 */
@Service
public class UserManagementService implements ProfileService, SocialUserDetailsService {

    private final Logger LOG = LoggerFactory.getLogger(UserManagementService.class);

    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;
    private final GroupRepository groupRepository;

    @Autowired
    public UserManagementService(ProfileRepository profileRepository, PasswordEncoder passwordEncoder
            , GroupRepository groupRepository) {
        this.profileRepository = profileRepository;
        this.passwordEncoder = passwordEncoder;
        this.groupRepository = groupRepository;
    }


    public String encodePassword(String rawPassword) {
        LOG.debug("Debut du Process 'encodePassword'");
        return passwordEncoder.encode(rawPassword);
    }

    public boolean matchPassword(String rawPassword, String passwordEncoded) {
        LOG.debug("Debut du Process 'matchPassword'");
        return passwordEncoder.matches(rawPassword,passwordEncoded);
    }

    public Profile affectedGroup(Profile profile,String groupName) {
        LOG.debug("Debut du Process 'affectedGroup'");
        Optional<Group> optionalGroup = groupRepository.findByName(groupName);
        User user = profile.getUser();
        if(user != null)
            optionalGroup.ifPresent(user::setGroup);
        return profile;
    }

    @Transactional(readOnly = true)
    public long countProfile() {
        LOG.debug("Debut du Process 'countProfile'");
        return profileRepository.count();
    }

    @Override
    public Profile save(Profile profile) {
        LOG.debug("Debut du Process 'save'");
        return profileRepository.save(profile);
    }

    @Override
    public Profile saveAndEncodePassword(Profile profile) {
        LOG.debug("Debut du Process 'save'");
        String rawPassword = profile.getPassword();
        String encodePassword = encodePassword(rawPassword);
        profile.setPassword(encodePassword);
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

    @Transactional(readOnly = true)
    @Override
    public SocialUserDetails loadUserByUserId(String s) throws UsernameNotFoundException {
        LOG.debug("Debut du Proces 'loadUserByUsername'");
        if (s != null) {
            Optional<Profile> optionalProfile = profileRepository.findByUsername(s);
            if (optionalProfile.isPresent()) {
                return optionalProfile.get();
            }
            throw new UsernameNotFoundException("Profile is not exist");
        } else
            throw new UsernameNotFoundException("Profile is null");
    }
}
