package org.codedivoire.dembesi.common.service;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.usermanagement.entity.Group;
import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.codedivoire.dembesi.usermanagement.entity.Role;
import org.codedivoire.dembesi.usermanagement.entity.User;
import org.codedivoire.dembesi.usermanagement.service.UserManagementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Christian Amani on 15/02/2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {UserManagementService.class, TokenService.class}))
@ActiveProfiles("embedded")
public class TokenServiceTest {

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TokenService tokenService;


    @Before
    public void setup() {
        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn("DBDNU384949CBNNDJD");
        Mockito.when(passwordEncoder.matches(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(true);
        Profile profile;
        Group groupRoot;
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
        User user = new User();
        user.setFirstName("Konan");
        user.setLastName("Koffi");
        user.setPhoneNumber("+225 XX-XX-XX-XX");
        user.setTemporalEventData(new TemporalEventData());
        user.setProfile(profile);
        user.setGroup(groupRoot);
        profile = entityManager.persist(profile);
        user.setProfile(profile);
        entityManager.persist(user);
    }


    @Test
    public void createTokenAccess() {
        String tokenAccess = tokenService.createTokenAccess("dembesi@mail.com", "password");
        assertNotNull(tokenAccess);
    }

    @Test
    public void tokenIsValid() {
        String tokenAccess = tokenService.createTokenAccess("dembesi@mail.com", "password");
        assertNotNull(tokenAccess);
        boolean isValid = tokenService.tokenIsValid(tokenAccess);
        assertTrue(isValid);
    }

    @Test
    public void getJwt() {
        String tokenAccess = tokenService.createTokenAccess("dembesi@mail.com", "password");
        assertNotNull(tokenAccess);
        DecodedJWT jwt = tokenService.getJwt(tokenAccess);
        assertNotNull(jwt);
        String subject = jwt.getSubject();
        assertEquals("dembesi@mail.com", subject);
        Claim passwordClaim = jwt.getClaim("password");
        assertNotNull(passwordClaim);
        assertEquals("password", passwordClaim.asString());
    }
}