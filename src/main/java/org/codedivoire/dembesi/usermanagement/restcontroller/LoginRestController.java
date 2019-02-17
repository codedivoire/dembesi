package org.codedivoire.dembesi.usermanagement.restcontroller;

import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.common.model.api.ApiResponse;
import org.codedivoire.dembesi.common.model.api.ErrorResponse;
import org.codedivoire.dembesi.common.model.api.GreatResponse;
import org.codedivoire.dembesi.common.model.api.StateResponse;
import org.codedivoire.dembesi.common.service.TokenService;
import org.codedivoire.dembesi.dictionary.utils.BuilderApiResponse;
import org.codedivoire.dembesi.usermanagement.entity.Profile;
import org.codedivoire.dembesi.usermanagement.entity.User;
import org.codedivoire.dembesi.usermanagement.model.RegisterForm;
import org.codedivoire.dembesi.usermanagement.service.UserManagementService;
import org.codedivoire.dembesi.usermanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Clock;
import java.time.LocalDateTime;

/**
 * @author Christian Amani on 15/02/2019.
 */
@RestController
public class LoginRestController {

    private final Logger LOG = LoggerFactory.getLogger(LoginRestController.class);
    private final String API_VERSION = "v0";
    private final String DOMAIN = "usermanagement";

    private final TokenService tokenService;
    private final UserManagementService userManagementService;
    private final UserService userService;

    @Autowired
    public LoginRestController(TokenService tokenService, UserManagementService userManagementService
            , UserService userService) {
        this.tokenService = tokenService;
        this.userManagementService = userManagementService;
        this.userService = userService;
    }

    @GetMapping("sign_in/api")
    public ResponseEntity<ApiResponse> signin(@RequestParam("username") String email,
                                              @RequestParam("password") String password) {
        LOG.debug("Debut du Process 'signin'");
        String tokenAccess = tokenService.createTokenAccess(email, password);
        if (tokenAccess != null) {
            GreatResponse greatResponse = BuilderApiResponse.builder()
                    .greatResponseApiVersion(API_VERSION)
                    .greatResponseDomain(DOMAIN)
                    .greatResponseItem(tokenAccess)
                    .greatResponseState(StateResponse.success)
                    .buildGreatResponse();
            return new ResponseEntity<>(greatResponse, HttpStatus.OK);
        } else {
            ErrorResponse errorResponse = BuilderApiResponse.builder()
                    .errorResponseState(API_VERSION)
                    .errorResponseState(StateResponse.fail)
                    .errorResponseAddErrorData(DOMAIN, "Authentication fail", "User Not Found")
                    .buildErrorResponse();
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "sign_up/api", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ApiResponse> signup(@RequestBody @Valid RegisterForm registerForm) {
        LOG.debug("Debut du Process 'signup'");
        LocalDateTime created = LocalDateTime.now(Clock.systemUTC());
        Profile profile = RegisterForm.toProfile(registerForm);
        TemporalEventData temporalEventDataProfile = profile.getTemporalEventData();
        temporalEventDataProfile.setCreated(created);
        User user = RegisterForm.toUser(registerForm);
        TemporalEventData temporalEventDataUser = user.getTemporalEventData();
        temporalEventDataUser.setCreated(created);
        user.setTemporalEventData(temporalEventDataUser);
        String group = registerForm.getGroup();
        profile.setUser(user);
        user.setProfile(profile);
        profile = userManagementService.affectedGroup(profile,group);
        profile = userManagementService.saveAndEncodePassword(profile);
        String email = registerForm.getEmail();
        String password = registerForm.getPassword();
        String tokenAccess = tokenService.createTokenAccess(email, password);
        profile.setResetToken(tokenAccess);
        if (profile != null) {
            GreatResponse greatResponse = BuilderApiResponse.builder()
                    .greatResponseApiVersion(API_VERSION)
                    .greatResponseDomain(DOMAIN)
                    .greatResponseState(StateResponse.success)
                    .greatResponseItem(profile)
                    .buildGreatResponse();
            return new ResponseEntity<>(greatResponse, HttpStatus.OK);
        } else {
            ErrorResponse errorResponse = BuilderApiResponse.builder()
                    .errorResponseState(API_VERSION)
                    .errorResponseState(StateResponse.fail)
                    .errorResponseAddErrorData(DOMAIN, "Registration fail", "Can not create user")
                    .buildErrorResponse();
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
}
