package org.codedivoire.dembesi.dictionary.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.dictionary.model.Opinion;
import org.codedivoire.dembesi.dictionary.model.State;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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
    private List<Definition> definitions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<Diction> dictions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<Etymology> etymologies = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<GeoLocation> geoLocations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<MediaLink> mediaLinkList = new ArrayList<>();

    @Value("classpath:/org.codedivoire.dembesi.dictionary.model.Opinion")
    @JsonUnwrapped
    private Opinion opinion;

    @Value("classpath:/org.codedivoire.dembesi.common.model.TemporalEventData")
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

    public void addDefinition(Definition definition) {
        if (definition != null) {
            definitions.add(definition);
            definition.setOwner(this);
        }
    }

    public void removeDefinition(Definition definition) {
        if (definition != null) {
            definitions.remove(definition);
            definition.setOwner(null);
        }
    }

    public List<Diction> getDictions() {
        return dictions;
    }

    public void setDictions(List<Diction> dictions) {
        this.dictions = dictions;
    }

    public void addDiction(Diction diction) {
        if (diction != null) {
            dictions.add(diction);
            diction.setOwner(this);
        }
    }

    public void removeDiction(Diction diction) {
        if (diction != null) {
            dictions.remove(diction);
            diction.setOwner(null);
        }
    }

    public List<Etymology> getEtymologies() {
        return etymologies;
    }

    public void setEtymologies(List<Etymology> etymologies) {
        this.etymologies = etymologies;
    }

    public void addEtymology(Etymology etymology) {
        if (etymology != null) {
            etymologies.add(etymology);
            etymology.setOwner(this);
        }
    }

    public void removeEtymology(Etymology etymology) {
        if (etymology != null) {
            etymologies.remove(etymology);
            etymology.setOwner(null);
        }
    }

    public List<GeoLocation> getGeoLocations() {
        return geoLocations;
    }

    public void setGeoLocations(List<GeoLocation> geoLocations) {
        this.geoLocations = geoLocations;
    }

    public void addGeoLocation(GeoLocation geoLocation) {
        if (geoLocation != null) {
            geoLocations.add(geoLocation);
            geoLocation.setOwner(this);
        }
    }

    public void removeGeoLocation(GeoLocation geoLocation) {
        if (geoLocation != null) {
            geoLocations.remove(geoLocation);
            geoLocation.setOwner(null);
        }
    }

    public List<MediaLink> getMediaLinkList() {
        return mediaLinkList;
    }

    public void setMediaLinkList(List<MediaLink> mediaLinkList) {
        this.mediaLinkList = mediaLinkList;
    }

    public void addMediaLink(MediaLink mediaLink) {
        if (mediaLink != null) {
            mediaLinkList.add(mediaLink);
            mediaLink.setOwner(this);
        }
    }

    public void removeMediaLink(MediaLink mediaLink) {
        if (mediaLink != null) {
            mediaLinkList.add(mediaLink);
            mediaLink.setOwner(null);
        }
    }

    public TemporalEventData getTemporalEventData() {
        return temporalEventData;
    }

    public void setTemporalEventData(TemporalEventData temporalEventData) {
        this.temporalEventData = temporalEventData;
    }

    public Opinion getOpinion() {
        return opinion;
    }

    public void setOpinion(Opinion opinion) {
        this.opinion = opinion;
    }
}
