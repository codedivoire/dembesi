package org.codedivoire.dembesi.usermanagement.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Christian Amani on 16/01/2019.
 */
@Table(name = "groupe_utilisateur")
@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom",unique = true)
    private String name;

    @Column(name = "libelle")
    private String label;

    @Column(length = 10000)
    private String description;

    @Value("classpath:/org.codedivoire.dembesi.common.model.TemporalEventData")
    @JsonUnwrapped
    private TemporalEventData temporalEventData;

    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users = new HashSet<>();

    public Group() {

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        if(user != null) {
            users.add(user);
            user.setGroup(this);
        }
    }

    public void removeUser(User user) {
        if(user != null) {
            users.remove(user);
            user.setGroup(null);
        }
    }
}
