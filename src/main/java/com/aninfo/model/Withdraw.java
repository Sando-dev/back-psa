package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Withdraw extends Transaction {
    public Withdraw() {
        // Default constructor for test cases
        super();
    }

    public Withdraw(Account account, double sum) {
        super(account, sum);
    }
}