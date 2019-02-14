package org.codedivoire.dembesi.usermanagement.repository;

import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Christian Amani on 17/01/2019.
 */
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByEmail(String email);

    Optional<Profile> findByUsername(String username);
}
