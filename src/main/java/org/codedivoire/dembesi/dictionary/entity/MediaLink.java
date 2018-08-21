package org.codedivoire.dembesi.dictionary.entity;

import org.codedivoire.dembesi.dictionary.model.MediaType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author  Christian Amani on 21/08/2018.
 */
@Table(name = "media")
@Entity
public class MediaLink {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dembesi_generator")
    @SequenceGenerator(name = "dembesi_generator", sequenceName = "media_sequence",allocationSize = 1)
    private long id;

    @Column(name = "lien")
    @NotNull
    @NotEmpty
    @NotBlank
    private String link;

    @Column(name = "legende")
    private String caption;

    @Column(name = "type")
    private MediaType mediaType;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Name.class)
    @JoinColumn(name="nom_id")
    private AbstractName owner;

    public MediaLink() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public AbstractName getOwner() {
        return owner;
    }

    public void setOwner(AbstractName owner) {
        this.owner = owner;
    }
}
