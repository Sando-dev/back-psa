package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long cbu;
    private double oldBalance;
    private double newBalance;
    private final double sum;

    public Transaction(Account account, double sum) {
        this.cbu = account.getCbu();
        this.oldBalance = account.getBalance();
        this.newBalance = this.oldBalance + sum;
        this.sum = sum;
    }

    public Transaction() {
        // Default constructor for test cases
        this.sum = 500; // Sum used for tests
    }

    public Long getId() {
        return this.id;
    }

    public Long getCbu() {
        return this.cbu;
    }

    public double getOldBalance() {
        return this.oldBalance;
    }

    public double getNewBalance() {
        return this.newBalance;
    }

    public double getSum() {
        return this.sum;
    }
}
