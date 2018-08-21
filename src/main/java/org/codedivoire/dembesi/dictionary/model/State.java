package org.codedivoire.dembesi.dictionary.model;

/**
 *
 * Enum representing the various states a {@link org.codedivoire.dembesi.dictionary.entity.Definition,org.codedivoire.dembesi.dictionary.entity.Diction,org.codedivoire.dembesi.dictionary.entity.Etymology,org.codedivoire.dembesi.dictionary.entity.GeoLocation}
 * can be within the system.
 *
 * @author  Christian Amani on 21/08/2018.
 */
public enum State {

    /**
     * Entry just got added to the system. Not visible to users who search yet
     */
    NEW,
    /**
     * Data has been indexed in the search engine, thus publish and users can find it when they search for it
     */
    PUBLISHED,
    /**
     * A Data that was initially published but has been removed from the index
     */
    UNPUBLISHED,
    /**
     * A Data that has been published (indexed into the search engine) was modified, thus needs to be re-indexed
     */
    MODIFIED,
    /**
     * A Data that was submitted by an anonymous user (indexed into the search engine) was modified, thus needs to be re-indexed
     */
    SUGGESTED
}
