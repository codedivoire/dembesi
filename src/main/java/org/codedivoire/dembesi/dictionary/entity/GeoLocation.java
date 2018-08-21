package org.codedivoire.dembesi.dictionary.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author  Christian Amani on 21/08/2018.
 */
@Table(name = "geolocalisation")
@Entity
public class GeoLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dembesi_generator")
    @SequenceGenerator(name = "dembesi_generator", sequenceName = "geolocalisation_sequence",allocationSize = 1)
    private long id;

    @Column(name = "region")
    @NotNull
    @NotBlank
    @NotEmpty
    private String region;

    @Column(name = "localisation")
    private String localisation;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Name.class)
    @JoinColumn(name="nom_id")
    private AbstractName owner;

    public GeoLocation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public AbstractName getOwner() {
        return owner;
    }

    public void setOwner(AbstractName owner) {
        this.owner = owner;
    }
}
