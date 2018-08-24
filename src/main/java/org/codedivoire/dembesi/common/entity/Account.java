package org.codedivoire.dembesi.common.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.codedivoire.dembesi.common.model.AccountDetails;
import org.codedivoire.dembesi.common.model.StateAccount;
import org.codedivoire.dembesi.common.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

/**
 * @author  Christian Amani on 23/08/2018.
 */
@Table(name = "compte")
@Entity
public class Account implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dembesi_generator")
    @SequenceGenerator(name = "dembesi_generator", sequenceName = "account_sequence",allocationSize = 1)
    private long id;

    @Column(name = "date_creation")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDate created;

    private User user;

    private AccountDetails accountDetails;

    @Column(name = "status")
    private StateAccount stateAccount;

    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    public StateAccount getStateAccount() {
        return stateAccount;
    }

    public void setStateAccount(StateAccount stateAccount) {
        this.stateAccount = stateAccount;
    }

    public void setMail(String mail) {
        if(user != null) {
            user.setMail(mail);
        }
    }

    public String getMail() {
        return user.getMail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(accountDetails != null) {
            String authorities = accountDetails.getAuthorities();
            if(authorities != null)
                return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
        }
        return AuthorityUtils.NO_AUTHORITIES;
    }

    @Override
    public String getPassword() {
        if(accountDetails != null)
            return accountDetails.getPassword();
        return null;
    }

    @Override
    public String getUsername() {
        if(user != null)
            return user.getLastName();
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return stateAccount == StateAccount.ACTIVE;
    }
}
