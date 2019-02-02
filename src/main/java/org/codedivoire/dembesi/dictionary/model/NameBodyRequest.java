package org.codedivoire.dembesi.dictionary.model;

import org.codedivoire.dembesi.dictionary.entity.*;

import javax.validation.constraints.NotNull;

/**
 * @author Christian Amani on 23/01/2019.
 */
public class NameBodyRequest {

    @NotNull
    private Name name;

    private Definition definition;

    private Etymology etymologie;

    private GeoLocation geoLocation;

    private MediaLink mediaLink;

    private Diction diction;

    public NameBodyRequest() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public Etymology getEtymologie() {
        return etymologie;
    }

    public void setEtymologie(Etymology etymologie) {
        this.etymologie = etymologie;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public MediaLink getMediaLink() {
        return mediaLink;
    }

    public void setMediaLink(MediaLink mediaLink) {
        this.mediaLink = mediaLink;
    }

    public Diction getDiction() {
        return diction;
    }

    public void setDiction(Diction diction) {
        this.diction = diction;
    }
}
