package org.codedivoire.dembesi.usermanagement.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author Christian Amani on 16/01/2019.
 */
@Table(name = "role_utilisateur")
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom",unique = true)
    private String name;

    @Column(name = "libeller")
    private String label;

    @Column(length = 10000)
    private String description;

    @Value("classpath:/org.codedivoire.dembesi.common.model.TemporalEventData")
    @JsonUnwrapped
    private TemporalEventData temporalEventData;

    public Role() {

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TemporalEventData getTemporalEventData() {
        return temporalEventData;
    }

    public void setTemporalEventData(TemporalEventData temporalEventData) {
        this.temporalEventData = temporalEventData;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
