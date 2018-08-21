package org.codedivoire.dembesi.dictionary.entity;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dembesi_generator")
    @SequenceGenerator(name = "dembesi_generator", sequenceName = "etymologie_sequence",allocationSize = 1)
    private long id;

    @Column(name = "origine")
    @NotNull
    @NotBlank
    @NotEmpty
    private String origin;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Name.class)
    @JoinColumn(name="nom_id")
    private AbstractName owner;

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

    public AbstractName getOwner() {
        return owner;
    }

    public void setOwner(AbstractName owner) {
        this.owner = owner;
    }
}
