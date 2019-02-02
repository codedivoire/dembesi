package org.codedivoire.dembesi.dictionary.service;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Christian Amani on 23/01/2019.
 */
public interface CRUDService<T> {

    Optional<T> save(T object);

    Collection<T> save(Collection<T> object);

    Optional<T> find(long id);

    Collection<T> find();

    boolean delete(T object);
}
