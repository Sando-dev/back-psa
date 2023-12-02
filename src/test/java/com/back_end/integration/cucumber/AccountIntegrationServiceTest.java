package com.back_end.integration.cucumber;

import com.back_end.PSAApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = PSAApp.class)
@WebAppConfiguration
public class AccountIntegrationServiceTest {
    /*
    @Autowired
    AccountService accountService;

    Account createAccount(Double balance) {
        return accountService.createAccount(new Account(balance));
    }

    Account withdraw(Account account, Double sum) {
        return accountService.withdraw(account.getCbu(), sum);
    }

    Account deposit(Account account, Double sum) {
        return accountService.deposit(account.getCbu(), sum);
    }
    */
}
