package org.codedivoire.dembesi.common.configuration;

import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.codedivoire.dembesi.usermanagement.model.RegisterForm;
import org.codedivoire.dembesi.usermanagement.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Christian Amani on 09/02/2019.
 */
@Component
public class FacebookConnectionSignup implements ConnectionSignUp {

    private final Logger LOG = LoggerFactory.getLogger(FacebookConnectionSignup.class);

    private final UserManagementService userManagementService;

    @Autowired
    public FacebookConnectionSignup(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @Override
    public String execute(Connection<?> connection) {
        String displayName = connection.getDisplayName();
        String accessToken = connection.createData()
                .getAccessToken();
        Facebook facebook = new FacebookTemplate(accessToken);
        String[] fields = {"id", "about", "age_range", "birthday", "context", "cover", "currency", "devices"
                , "education", "email", "favorite_athletes", "favorite_teams", "first_name", "gender", "hometown"
                , "inspirational_people", "installed", "install_type", "is_verified", "languages", "last_name", "link"
                , "locale", "location", "meeting_for", "middle_name", "name", "name_format", "political", "quotes"
                , "payment_pricepoints", "relationship_status", "religion", "security_settings", "significant_other"
                , "sports", "test_group", "timezone", "third_party_id", "updated_time", "verified", "video_upload_limits"
                , "viewer_can_send_gift", "website", "work"};
        User facebookUser = facebook.fetchObject("me", User.class, fields);
        LOG.info(facebookUser.getEmail());
        long size = userManagementService.countProfile();
        Profile profile = RegisterForm.fromFacebookUser(facebookUser,size);
        org.codedivoire.dembesi.usermanagement.entity.User user = RegisterForm.fromFacebookUser(facebookUser);
        user.setProfile(profile);
        profile.setUser(user);
        userManagementService.save(profile);
        return displayName;
    }
}
