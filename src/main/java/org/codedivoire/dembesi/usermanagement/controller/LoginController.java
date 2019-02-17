package org.codedivoire.dembesi.usermanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Christian Amani on 12/02/2019.
 */
@Controller
public class LoginController {

    private final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
