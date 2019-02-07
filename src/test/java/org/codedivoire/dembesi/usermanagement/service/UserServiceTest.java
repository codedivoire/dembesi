package org.codedivoire.dembesi.usermanagement.service;

import org.codedivoire.dembesi.common.configuration.CommonConfiguration;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.usermanagement.entity.Group;
import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.codedivoire.dembesi.usermanagement.entity.Role;
import org.codedivoire.dembesi.usermanagement.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Christian Amani on 02/02/2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE
        ,value = {UserService.class,UserManagementService.class, CommonConfiguration.class}))
@ActiveProfiles("embedded")
public class UserServiceTest {

    private final String ROLE_ROOT = "ROLE_ROOT";
    private final String ROLE_USER = "ROLE_USER";
    private final String GROUP_ROOT = "GROUP_ROOT";

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserService userService;
    @Autowired
    private UserManagementService userManagementService;

    private User user;


    @Before
    public void setup() {
        Role roleRoot = new Role();
        roleRoot.setTemporalEventData(new TemporalEventData());
        roleRoot.setName(ROLE_ROOT);
        entityManager.persist(roleRoot);
        Role roleUser = new Role();
        roleUser.setTemporalEventData(new TemporalEventData());
        roleUser.setName(ROLE_USER);
        entityManager.persist(roleUser);
        Group groupRoot = new Group();
        groupRoot.setTemporalEventData(new TemporalEventData());
        groupRoot.setName(GROUP_ROOT);
        groupRoot = entityManager.persist(groupRoot);
        Group groupUser = new Group();
        groupUser.setTemporalEventData(new TemporalEventData());
        String GROUP_USER = "GROUP_USER";
        groupUser.setName(GROUP_USER);
        groupUser  = entityManager.persist(groupUser);
        Profile profile = new Profile();
        profile.setEmail("dembesi@mail.com");
        profile.setUsername("dembe");
        profile.setPassword("password");
        profile.setTemporalEventData(new TemporalEventData());
        profile.setGender(Profile.Gender.male);
        user = new User();
        user.setFirstName("Konan");
        user.setLastName("Koffi");
        user.setPhoneNumber("+225 XX-XX-XX-XX");
        user.setTemporalEventData(new TemporalEventData());
        user.setProfile(profile);
        user.setGroup(groupRoot);
        profile = entityManager.persist(profile);
        user.setProfile(profile);
        user = entityManager.persist(user);
    }


    @Test
    public void addRole() {
        Profile profile = user.getProfile();
        userService.addRole(profile.getId(),ROLE_ROOT);
        profile = userService.addRole(profile.getId(),ROLE_USER);
        Set<Role> roles =  profile.getAuthorities();
        roles.forEach(role -> {
            assertTrue(role.getName().equals(ROLE_ROOT) || role.getName().equals(ROLE_USER));
        });
    }

    @Test
    public void removeRoles() {
        Profile profile = user.getProfile();
        long id = profile.getId();
        userService.addRole(id,ROLE_ROOT);
        profile = userService.addRole(id,ROLE_USER);
        assertNotEquals(0,profile.getAuthorities().size());
        userService.removeRoles(id);
        profile = userManagementService.find(id);
        assertEquals(0,profile.getAuthorities().size());
        profile.getAuthorities().size();
    }

    @Test
    public void setGroup() {
        long id = user.getProfile().getId();
        userService.setGroup(id,GROUP_ROOT);
        Profile profile = userManagementService.find(id);
        String name = profile.getUser()
                .getGroup()
                .getName();
        assertEquals(GROUP_ROOT,name);
    }

    @Test
    public void deleted() {
        userService.deleted(user.getId());
        Profile profile = userManagementService.find(user.getProfile().getId());
        assertNotNull(profile.getTemporalEventData().getDeleted());
    }

    @Test
    public void isDeleted() {
        userService.deleted(user.getId());
        boolean isDeleted = userService.isDeleted(user.getId());
        assertTrue(isDeleted);
    }
}