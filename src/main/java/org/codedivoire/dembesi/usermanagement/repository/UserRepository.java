package org.codedivoire.dembesi.usermanagement.repository;

import org.codedivoire.dembesi.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Christian Amani on 17/01/2019.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
