package org.codedivoire.dembesi.usermanagement.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.codedivoire.dembesi.usermanagement.model.TemporalEventData;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Christian Amani on 16/01/2019.
 */
@Table(name = "profile")
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean active;

    @Column(name = "token")
    private String resetToken;

    @Column(name = "totale_login")
    private long totalLogin;

    @Column(name = "expiration_token")
    private LocalDateTime resetTokenExpiation;

    @Column(name = "derniere_connexion")
    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @JsonUnwrapped
    private TemporalEventData temporalEventData;

    public Profile() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public long getTotalLogin() {
        return totalLogin;
    }

    public void setTotalLogin(long totalLogin) {
        this.totalLogin = totalLogin;
    }

    public LocalDateTime getResetTokenExpiation() {
        return resetTokenExpiation;
    }

    public void setResetTokenExpiation(LocalDateTime resetTokenExpiation) {
        this.resetTokenExpiation = resetTokenExpiation;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public TemporalEventData getTemporalEventData() {
        return temporalEventData;
    }

    public void setTemporalEventData(TemporalEventData temporalEventData) {
        this.temporalEventData = temporalEventData;
    }

    public enum Status {
        offline,
        online,
        away,
        invisible,
        doNotDisturb
    }
}
