package org.codedivoire.dembesi.usermanagement.model;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.codedivoire.dembesi.usermanagement.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Christian Amani on 12/02/2019.
 */
public class RegisterForm {

    @Email
    @NotNull
    private String email;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    private Profile.Gender gender;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String numberPhone;

    @NotEmpty
    private String group;

    private String country;

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

    public Profile.Gender getGender() {
        return gender;
    }

    public void setGender(Profile.Gender gender) {
        this.gender = gender;
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static Profile toProfile(RegisterForm form) {
        if (form != null) {
            Profile profile = new Profile();
            String username = form.getUsername();
            profile.setUsername(username);
            String email = form.getEmail();
            profile.setEmail(email);
            String password = form.getPassword();
            profile.setPassword(password);
            Profile.Gender gender = form.getGender();
            profile.setGender(gender);
            TemporalEventData temporalEventData = new TemporalEventData();
            profile.setTemporalEventData(temporalEventData);
            return profile;
        }
        return null;
    }

    public static User toUser(RegisterForm form) {
        if (form != null) {
            User user = new User();
            String firstName = form.getFirstName();
            user.setFirstName(firstName);
            String lastName = form.getLastName();
            user.setLastName(lastName);
            String numberPhone = form.getNumberPhone();
            user.setPhoneNumber(numberPhone);
            String country = form.getCountry();
            user.setCountry(country);
            TemporalEventData temporalEventData = new TemporalEventData();
            user.setTemporalEventData(temporalEventData);
            return user;
        }
        return null;
    }

    public static Profile fromFacebookUser(org.springframework.social.facebook.api.User user, long sizeProfiles) {
        if (user != null) {
            Profile profile = new Profile();
            String name = user.getName();
            name = name.trim();
            profile.setUsername(name);
            setEmail(profile, name, sizeProfiles);
            String gender = user.getGender();
            if (gender != null)
                profile.setGender(Profile.Gender.fromString(gender));
            else
                profile.setGender(Profile.Gender.unknown);
            profile.setPassword("dembesipassword");
            TemporalEventData temporalEventData = new TemporalEventData();
            profile.setTemporalEventData(temporalEventData);
        }
        return null;
    }

    private static void setEmail(Profile profile, String name, long sizeProfiles) {
        String email = profile.getEmail();
        if (email != null) {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            try {
                phoneNumberUtil.parse(email, "CI");
            } catch (NumberParseException e) {
                profile.setEmail(email);
            }
        } else
            profile.setEmail(name + sizeProfiles + "@dembesi.com");
    }

    public static User fromFacebookUser(org.springframework.social.facebook.api.User facebookUser) {
        if (facebookUser != null) {
            User user = new User();
            String firstName = facebookUser.getFirstName();
            if (firstName != null)
                user.setFirstName(firstName);
            else
                user.setFirstName("");
            String lastName = facebookUser.getLastName();
            if (lastName != null)
                user.setLastName(lastName);
            else
                user.setLastName("");
            user.setPhoneNumber("+225XXXXXXXX");
            TemporalEventData temporalEventData = new TemporalEventData();
            user.setTemporalEventData(temporalEventData);
            return user;
        }
        return null;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
