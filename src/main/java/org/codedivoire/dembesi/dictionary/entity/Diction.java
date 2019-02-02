package org.codedivoire.dembesi.dictionary.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.dictionary.model.Opinion;
import org.codedivoire.dembesi.dictionary.model.State;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Christian Amani on 21/08/2018.
 */
@Table(name = "prononciation")
@Entity
public class Diction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "prononciation")
    @NotNull
    @NotEmpty
    @NotBlank
    private String pronunciation;

    @Column(name = "url")
    private String uri;

    @Column(name = "flux_audio")
    private byte[] audioStream;

    @Column(name = "status")
    private State state;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Name.class)
    @JoinColumn(name = "nom_id")
    private Name owner;

    @JsonUnwrapped
    private TemporalEventData temporalEventData;

    @JsonUnwrapped
    private Opinion opinion;

    public Diction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public byte[] getAudioStream() {
        return audioStream;
    }

    public void setAudioStream(byte[] audioStream) {
        this.audioStream = audioStream;
    }

    public Name getOwner() {
        return owner;
    }

    public void setOwner(Name owner) {
        this.owner = owner;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Opinion getOpinion() {
        return opinion;
    }

    public void setOpinion(Opinion opinion) {
        this.opinion = opinion;
    }

    public TemporalEventData getTemporalEventData() {
        return temporalEventData;
    }

    public void setTemporalEventData(TemporalEventData temporalEventData) {
        this.temporalEventData = temporalEventData;
    }
}
