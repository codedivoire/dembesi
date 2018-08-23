package org.codedivoire.dembesi.common.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.codedivoire.dembesi.common.model.StateAccount;
import org.codedivoire.dembesi.common.model.User;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author  Christian Amani on 23/08/2018.
 */
@Table(name = "compte")
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dembesi_generator")
    @SequenceGenerator(name = "dembesi_generator", sequenceName = "account_sequence",allocationSize = 1)
    private long id;

    @Column(name = "status")
    private StateAccount stateAccount;

    @Column(name = "date_creation")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDate created;

    private User user;

    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StateAccount getStateAccount() {
        return stateAccount;
    }

    public void setStateAccount(StateAccount stateAccount) {
        this.stateAccount = stateAccount;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
