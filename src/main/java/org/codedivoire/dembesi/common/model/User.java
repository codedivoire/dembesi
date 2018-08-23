package org.codedivoire.dembesi.common.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author  Christian Amani on 23/08/2018.
 */
@Embeddable
public class User {

    @Column(name = "prenom")
    private String firstName;

    @Column(name = "nom")
    @NotEmpty
    @NotNull
    @NotBlank
    private String lastName;

    @Column(name = "date_naissance")
    private LocalDate birthDate;

    @Column(name = "genre")
    private String genre;

    @Column(name = "mail")
    @Email
    private String mail;

    @Column(name = "description")
    private String description;

    public User() {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
