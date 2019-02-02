package org.codedivoire.dembesi.dictionary.repository;

import jdk.nashorn.internal.runtime.options.Option;
import org.codedivoire.dembesi.dictionary.entity.Diction;
import org.codedivoire.dembesi.dictionary.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author  Christian Amani on 23/08/2018.
 */
@Repository
public interface DictionRepository extends JpaRepository<Diction,Long> {

    Optional<Diction> findByOwner(Name name);
}
