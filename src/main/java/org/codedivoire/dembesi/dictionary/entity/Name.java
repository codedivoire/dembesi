package org.codedivoire.dembesi.dictionary.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.dictionary.model.Opinion;
import org.codedivoire.dembesi.dictionary.model.State;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Christian Amani on 21/08/2018.
 */
@Table(name = "nom")
@Entity
public class Name {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @Column(name = "nom", nullable = false)
    private String name;

    @Column(name = "status")
    private State state;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<Definition> definitions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<Diction> dictions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<Etymology> etymologies;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<GeoLocation> geoLocations;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<MediaLink> mediaLinkList;

    @JsonUnwrapped
    private Opinion opinion;

    @JsonUnwrapped
    private TemporalEventData temporalEventData;

    public Name() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public List<Diction> getDictions() {
        return dictions;
    }

    public void setDictions(List<Diction> dictions) {
        this.dictions = dictions;
    }

    public List<Etymology> getEtymologies() {
        return etymologies;
    }

    public void setEtymologies(List<Etymology> etymologies) {
        this.etymologies = etymologies;
    }

    public List<GeoLocation> getGeoLocations() {
        return geoLocations;
    }

    public void setGeoLocations(List<GeoLocation> geoLocations) {
        this.geoLocations = geoLocations;
    }

    public List<MediaLink> getMediaLinkList() {
        return mediaLinkList;
    }

    public void setMediaLinkList(List<MediaLink> mediaLinkList) {
        this.mediaLinkList = mediaLinkList;
    }

    public TemporalEventData getTemporalEventData() {
        return temporalEventData;
    }

    public void setTemporalEventData(TemporalEventData temporalEventData) {
        this.temporalEventData = temporalEventData;
    }
}
