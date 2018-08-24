package org.codedivoire.dembesi.common.service.impl;

import org.codedivoire.dembesi.common.entity.Account;
import org.codedivoire.dembesi.common.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author  Christian Amani on 24/08/2018.
 */
@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {

    private final Logger LOG = LoggerFactory.getLogger(AccountDetailsServiceImpl.class);
    private final AccountService accountService;

    @Autowired
    public AccountDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.debug("Début du Process 'loadUserByUsername'");
        if(username != null) {
            Account account = accountService.find(username);
            if(account != null)
                return account;
            throw new UsernameNotFoundException("Account is not exist");
        } else
            throw new UsernameNotFoundException("Username is null");
    }
}
