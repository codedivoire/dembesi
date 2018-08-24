package org.codedivoire.dembesi.common.repository;

import org.codedivoire.dembesi.common.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Christian Amani on 23/08/2018.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByUser_MailAndAccountDetails_Password(String mail, String password);

    Account findByUser_Mail(String mail);

}
