package com.aninfo.service;

import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Account;
import com.aninfo.model.Withdraw;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService extends TransactionService {

    public Withdraw createWithdraw(Account account, double sum) {
        if (account.getBalance() < sum) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        Withdraw withdraw = new Withdraw(account, -sum);
        super.createTransaction(withdraw);
        return withdraw;
    }
}