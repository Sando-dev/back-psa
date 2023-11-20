package com.aninfo.service;

import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Collection<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> findById(long id) {
        return transactionRepository.findById(id);
    }

    public void deleteById(long id) {
        transactionRepository.deleteById(id);
    }
}