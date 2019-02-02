package org.codedivoire.dembesi.dictionary.repository;

import org.codedivoire.dembesi.dictionary.entity.GeoLocation;
import org.codedivoire.dembesi.dictionary.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *@author  Christian Amani on 23/08/2018.
 */
@Repository
public interface GeoLocationRepository extends JpaRepository<GeoLocation,Long>{

    Optional<GeoLocation> findByOwner(Name owner);
}
