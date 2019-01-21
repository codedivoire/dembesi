package org.codedivoire.dembesi.usermanagement.repository;

import org.codedivoire.dembesi.usermanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Christian Amani on 17/01/2019.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByNameIgnoreCase(String name);
}
