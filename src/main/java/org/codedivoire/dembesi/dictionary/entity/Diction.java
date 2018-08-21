package org.codedivoire.dembesi.dictionary.entity;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dembesi_generator")
    @SequenceGenerator(name = "dembesi_generator", sequenceName = "prononciation_sequence",allocationSize = 1)
    private long id;

    @Column(name = "prononciation")
    @NotNull
    @NotEmpty
    @NotBlank
    private String pronunciation;

    @Column(name = "flux_audio")
    private byte[] audioStream;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Name.class)
    @JoinColumn(name="nom_id")
    private AbstractName owner;

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

    public AbstractName getOwner() {
        return owner;
    }

    public void setOwner(AbstractName owner) {
        this.owner = owner;
    }
}
