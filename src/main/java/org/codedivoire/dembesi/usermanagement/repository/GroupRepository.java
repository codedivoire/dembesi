package org.codedivoire.dembesi.usermanagement.repository;

import org.codedivoire.dembesi.usermanagement.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Christian Amani on 17/01/2019.
 */
public interface GroupRepository extends JpaRepository<Group,Long> {

    Optional<Group> findByNameIgnoreCase(String name);
}
