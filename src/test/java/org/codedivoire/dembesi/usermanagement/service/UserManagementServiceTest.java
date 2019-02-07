package org.codedivoire.dembesi.usermanagement.service;

import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.usermanagement.entity.Group;
import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.codedivoire.dembesi.usermanagement.entity.Role;
import org.codedivoire.dembesi.usermanagement.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Christian Amani on 02/02/2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {UserManagementService.class}))
@ActiveProfiles("embedded")
public class UserManagementServiceTest {

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserManagementService userManagementService;

    private Profile profile;

    private Group groupRoot;

    @Before
    public void setup() {

        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn("DBDNU384949CBNNDJD");
        Mockito.when(passwordEncoder.matches(Mockito.anyString(),Mockito.anyString()))
                .thenReturn(true);

        Role roleRoot = new Role();
        roleRoot.setTemporalEventData(new TemporalEventData());
        String ROLE_ROOT = "ROLE_ROOT";
        roleRoot.setName(ROLE_ROOT);
        entityManager.persist(roleRoot);
        Role roleUser = new Role();
        roleUser.setTemporalEventData(new TemporalEventData());
        String ROLE_USER = "ROLE_USER";
        roleUser.setName(ROLE_USER);
        entityManager.persist(roleUser);
        groupRoot = new Group();
        groupRoot.setTemporalEventData(new TemporalEventData());
        String GROUP_ROOT = "GROUP_ROOT";
        groupRoot.setName(GROUP_ROOT);
        groupRoot = entityManager.persist(groupRoot);
        profile = new Profile();
        profile.setEmail("dembesi@mail.com");
        profile.setUsername("dembe");
        profile.setPassword("password");
        profile.setTemporalEventData(new TemporalEventData());
        profile.setGender(Profile.Gender.male);

    }

    @Test
    public void encodePassword() {
        String password = "password";
        String encodedPassword = userManagementService.encodePassword(password);
        assertNotEquals(password,encodedPassword);
    }

    @Test
    public void matchPassword() {
        String password = "password";
        String encodedPassword = userManagementService.encodePassword(password);
        boolean matched = userManagementService.matchPassword(password, encodedPassword);
        assertTrue(matched);
    }

    @Test
    public void save() {
        saveProfile();
    }

    @Test
    public void find() {
        saveProfile();
        Profile profile = userManagementService.find(1);
        assertNotNull(profile);
    }

    @Test
    public void find1() {
        saveProfile();
        Profile profile = userManagementService.find("dembesi@mail.com");
        assertNotNull(profile);
    }

    @Test
    public void loadUserByUsername() {
        saveProfile();
        UserDetails userDetails = userManagementService.loadUserByUsername("dembe");
        assertNotNull(userDetails);
    }

    private void saveProfile() {
        User user = new User();
        user.setFirstName("Konan");
        user.setLastName("Koffi");
        user.setPhoneNumber("+225 XX-XX-XX-XX");
        user.setTemporalEventData(new TemporalEventData());
        user.setProfile(profile);
        user.setGroup(groupRoot);
        profile = userManagementService.save(profile);
        user.setProfile(profile);
        entityManager.persist(user);
    }

}