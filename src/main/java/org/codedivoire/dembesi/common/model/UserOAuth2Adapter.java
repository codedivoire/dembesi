package org.codedivoire.dembesi.common.model;

import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.codedivoire.dembesi.usermanagement.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

/**
 * @author Christian Amani on 07/02/2019.
 */
public class UserOAuth2Adapter implements OAuth2User {

    private String id;
    private User user;
    private Profile profile;
    private OAuth2User oAuth2User;

    public UserOAuth2Adapter(OAuth2User oAuth2User) {
        this.oAuth2User = oAuth2User;
        user = new User();
        user.setTemporalEventData(new TemporalEventData());
        profile = new Profile();
        profile.setTemporalEventData(new TemporalEventData());
        toProfile();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oAuth2User.getAuthorities();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2User.getAttributes();
    }

    @Override
    public String getName() {
        return oAuth2User.getName();
    }

    public String getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public User getUser() {
        return user;
    }

    private void toProfile() {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        id = (String) attributes.get("id");
        String username = getName();
        profile.setUsername(username);
        String email = (String) attributes.get("email");
        profile.setEmail(email);
        String genderRaw = (String) attributes.get("gender");
        Profile.Gender gender = Profile.Gender.fromString(genderRaw);
        profile.setGender(gender);
    }

    private void toUser() {
        // TODO : implement later
        // TODO : See https://developers.facebook.com/docs/graph-api/reference/user/
    }
}
