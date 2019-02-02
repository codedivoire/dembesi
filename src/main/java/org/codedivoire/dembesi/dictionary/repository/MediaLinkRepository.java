package org.codedivoire.dembesi.dictionary.repository;

import org.codedivoire.dembesi.dictionary.entity.MediaLink;
import org.codedivoire.dembesi.dictionary.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author  Christian Amani on 23/08/2018.
 */
@Repository
public interface MediaLinkRepository extends JpaRepository<MediaLink,Long> {

    Optional<MediaLink> findByOwner(Name name);
}
