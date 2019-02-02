package org.codedivoire.dembesi.dictionary.repository;

import org.codedivoire.dembesi.dictionary.entity.Etymology;
import org.codedivoire.dembesi.dictionary.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.acl.Owner;
import java.util.Optional;

/**
 * @author  Christian Amani on 23/08/2018.
 */
@Repository
public interface EtymologyRepository  extends JpaRepository<Etymology,Long> {

    Optional<Etymology> findByOwner(Name owner);
}
