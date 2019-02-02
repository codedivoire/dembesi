package org.codedivoire.dembesi.dictionary.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.dictionary.model.Opinion;
import org.codedivoire.dembesi.dictionary.model.State;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Christian Amani on 21/08/2018.
 */
@Table(name = "etymologie")
@Entity
public class Etymology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "origine",length = 10000)
    @NotNull
    @NotEmpty
    private String origin;

    @Column(name = "origine_traduction_englaise",length = 10000)
    private String originEnglishTranslate;

    @Column(name = "status")
    private State state;

    @Value("classpath:/org.codedivoire.dembesi.common.model.TemporalEventData")
    @JsonUnwrapped
    private TemporalEventData temporalEventData;

    @Value("classpath:/org.codedivoire.dembesi.dictionary.model.Opinion")
    @JsonUnwrapped
    private Opinion opinion;

    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Name.class,optional = false)
    @JoinColumn(name="nom_id")
    private Name owner;

    public Etymology() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Name getOwner() {
        return owner;
    }

    public void setOwner(Name owner) {
        this.owner = owner;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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
