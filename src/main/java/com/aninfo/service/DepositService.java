package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.model.Account;
import com.aninfo.model.Deposit;
import org.springframework.stereotype.Service;

@Service
public class DepositService extends TransactionService {

    public Deposit createDeposit(Account account, double sum) {
        if (sum <= 0) {
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        }
        Deposit deposit = new Deposit(account, applyPromo(sum));
        super.createTransaction(deposit);
        return deposit;
    }

    private double applyPromo(double sum) {
        if (sum >= 5000) {
            sum += 500;
        } else if (sum >= 2000) {
            sum += sum * 0.1;
        }
        return sum;
    }
}