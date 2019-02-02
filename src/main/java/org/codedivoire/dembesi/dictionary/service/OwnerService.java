package org.codedivoire.dembesi.dictionary.service;

import org.codedivoire.dembesi.dictionary.entity.Name;

import java.util.Optional;

/**
 * @author Christian Amani on 24/01/2019.
 */
public interface OwnerService<T> {

    Optional<T> findByOwner(Name name);
}
