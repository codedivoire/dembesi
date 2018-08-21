package org.codedivoire.dembesi.dictionary.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Christian Amani on 21/08/2018.
 */
@MappedSuperclass()
public class AbstractName {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dembesi_generator")
    @SequenceGenerator(name = "dembesi_generator", sequenceName = "nom_sequence",allocationSize = 1)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "owner")
    protected List<Definition> definitions;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "owner")
    protected List<Diction> dictions;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "owner")
    protected List<Etymology> etymologies;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "owner")
    protected List<GeoLocation> geoLocations;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "owner")
    protected List<MediaLink> mediaLinkList;

}
