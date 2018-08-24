package org.codedivoire.dembesi.common.service;

import org.codedivoire.dembesi.common.entity.Account;
import org.codedivoire.dembesi.common.model.AccountDetails;
import org.codedivoire.dembesi.common.model.User;

/**
 * @author  Christian Amani on 23/08/2018.
 */
public interface AccountService {

    Account save(User user, AccountDetails accountDetails);

    Account find(String email);

    Account find(String email,String password);

    Account recoveryPassword(Account account);
}
