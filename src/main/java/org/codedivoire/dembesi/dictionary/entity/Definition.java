package org.codedivoire.dembesi.dictionary.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author  Christian Amani on 21/08/2018.
 */
@Table(name = "definition")
@Entity
public class Definition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dembesi_generator")
    @SequenceGenerator(name = "dembesi_generator", sequenceName = "definition_sequence",allocationSize = 1)
    private long id;

    @Column(name = "contenu",length = 10000)
    @NotBlank
    @NotEmpty
    @NotNull
    private String content;

    @Column(name = "contenu_anglais",length = 10000)
    private String englishContent;

    @Column(name = "contenu_langue_local")
    private String localLanguageContent;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime submittedAt;


    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Name.class)
    @JoinColumn(name="nom_id")
    private AbstractName owner;

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

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public AbstractName getOwner() {
        return owner;
    }

    public void setOwner(AbstractName owner) {
        this.owner = owner;
    }
}
