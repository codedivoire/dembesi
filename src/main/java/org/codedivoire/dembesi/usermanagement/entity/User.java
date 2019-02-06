package org.codedivoire.dembesi.usermanagement.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Christian Amani on 16/01/2019.
 */
@Table(name = "utilisateur")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @NotNull
    @Column(name = "prenom")
    private String firstName;

    @NotNull
    @Column(name = "nom")
    private String lastName;

    @Column(name = "date_naissance")
    private LocalDate birthDate;

    @NotNull
    @NotEmpty
    @Column(name = "numero_phone")
    private String phoneNumber;

    @Column(name = "numero_phone_2")
    private String phoneNumber2;

    @Column(name = "adresse")
    private String address;

    @Column(name = "adresse_2")
    private String address2;

    @Column(name = "region")
    private String state;

    @Column(name = "ville")
    private String city;

    @Column(name = "pays")
    private String country;

    @Value("classpath:/org.codedivoire.dembesi.common.model.TemporalEventData")
    @JsonUnwrapped
    private TemporalEventData temporalEventData;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Group group;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn()
    private Profile profile;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TemporalEventData getTemporalEventData() {
        return temporalEventData;
    }

    public void setTemporalEventData(TemporalEventData temporalEventData) {
        this.temporalEventData = temporalEventData;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
        this.profile.setUser(this);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        if(role != null)
            roles.add(role);
    }

    public void removeRole(Role role) {
        if(role != null)
            roles.remove(role);
    }
}
