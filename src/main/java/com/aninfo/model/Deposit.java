package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Deposit extends Transaction {
    public Deposit() {
        // Default constructor for test cases
        super();
    }

    public Deposit(Account account, double sum) {
        super(account, sum);
    }
}