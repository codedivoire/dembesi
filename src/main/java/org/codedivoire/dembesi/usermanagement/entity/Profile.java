package org.codedivoire.dembesi.usermanagement.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.codedivoire.dembesi.usermanagement.model.TemporalEventData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author Christian Amani on 16/01/2019.
 */
@Table(name = "profile")
@Entity
public class Profile implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @Column(name = "email")
    private String email;

    @NotNull
    @NotEmpty
    @Column
    private String username;

    @NotNull
    @NotEmpty
    @Column
    private String password;

    @Value("true")
    @Column
    private boolean active;

    @Value("false")
    @Column(name = "verouiller")
    private boolean locked;

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

    @NotNull
    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @JsonUnwrapped
    private TemporalEventData temporalEventData;


    @NotNull
    @OneToOne(
            mappedBy = "profile",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(nullable = false)
    private User user;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public TemporalEventData getTemporalEventData() {
        return temporalEventData;
    }

    public void setTemporalEventData(TemporalEventData temporalEventData) {
        this.temporalEventData = temporalEventData;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addUser(User user) {
        if (user != null) {
            user.setProfile(this);
            this.user = user;
        }
    }

    public void removeUser(User user) {
        if (user != null) {
            user.setProfile(null);
            this.user = null;
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public enum Status {
        offline,
        online,
        away,
        invisible,
        doNotDisturb
    }

    public enum Gender {
        mal,
        female
    }
}
