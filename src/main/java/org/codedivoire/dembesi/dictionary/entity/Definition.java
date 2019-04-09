package org.codedivoire.dembesi.dictionary.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.dictionary.model.Opinion;
import org.codedivoire.dembesi.dictionary.model.State;
import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Christian Amani on 21/08/2018.
 */
@Table(name = "definition")
@Entity
public class Definition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "contenu", length = 10000)
    @NotEmpty
    @NotNull
    private String content;

    @Column(name = "contenu_anglais", length = 10000)
    private String englishContent;

    @Column(name = "contenu_langue_local", length = 10000)
    private String localLanguageContent;

    @Column(name = "status")
    private State state;

    @Value("classpath:/org.codedivoire.dembesi.common.model.TemporalEventData")
    @JsonUnwrapped
    private TemporalEventData temporalEventData;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Name.class,optional = false)
    @JoinColumn(name = "nom_id")
    private Name owner;


    @Value("classpath:/org.codedivoire.dembesi.dictionary.model.Opinion")
    @JsonUnwrapped
    private Opinion opinion;

    public Definition() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEnglishContent() {
        return englishContent;
    }

    public void setEnglishContent(String englishContent) {
        this.englishContent = englishContent;
    }

    public String getLocalLanguageContent() {
        return localLanguageContent;
    }

    public void setLocalLanguageContent(String localLanguageContent) {
        this.localLanguageContent = localLanguageContent;
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
