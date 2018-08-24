package org.codedivoire.dembesi.common.service.impl;

import org.codedivoire.dembesi.common.entity.Account;
import org.codedivoire.dembesi.common.model.AccountDetails;
import org.codedivoire.dembesi.common.model.User;
import org.codedivoire.dembesi.common.repository.AccountRepository;
import org.codedivoire.dembesi.common.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Christian Amani on 23/08/2018.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    final AccountRepository accountRepository;

    final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Account save(User user, AccountDetails accountDetails) {
        LOG.debug("Début Process 'save'");
        if(user != null && accountDetails != null) {
            Account account = new Account();
            account.setUser(user);
            String password = accountDetails.getPassword();
            password = encodePassword(password);
            accountDetails.setPassword(password);
            account.setAccountDetails(accountDetails);
            return accountRepository.save(account);
        }
        return null;
    }

    @Override
    public Account find(String email) {
        LOG.debug("Début Process 'find'");
        if(email != null)
            return accountRepository.findByUser_Mail(email);
        return null;
    }

    @Override
    public Account find(String email, String password) {
        LOG.debug("Début Process 'find'");
        if(email != null && password != null)
            return accountRepository.findByUser_MailAndAccountDetails_Password(email, password);
        return null;
    }

    @Override
    public Account recoveryPassword(Account account) {
        // TODO : implement later
        return null;
    }

    private String encodePassword(String password) {
        LOG.debug("Début du Process 'encodePassword'");
        if(password != null) {
            password = passwordEncoder.encode(password);
        }
        return password;
    }
}
