package org.codedivoire.dembesi.common.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Christian Amani on 23/08/2018.
 */

@Embeddable
public class AccountDetails {

    @Column(name = "mot_passe")
    private String password;

    @Column(name = "autorite")
    private String authorities;


    public AccountDetails() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }


    public void addAuthority(GrantedAuthority grantedAuthority) {
        if (grantedAuthority != null) {
            String authority = grantedAuthority.getAuthority();
            if (authorities.isEmpty())
                authorities = authority;
            else
                authorities += "," + authority;
        }
    }

    public void removeAuthority(GrantedAuthority grantedAuthority) {
        if (grantedAuthority != null) {
            String authority = grantedAuthority.getAuthority();
            if (!authorities.isEmpty()) {
                boolean authorityIsContained = authorities.contains(authority);
                if (authorityIsContained) {
                    authorities = authorities.replace(authority, "");
                    boolean doubleComaIsContained = authorities.contains(",,");
                    if (doubleComaIsContained)
                        authorities = authorities.replace(",,", ",");
                }
            }
        }
    }
}
