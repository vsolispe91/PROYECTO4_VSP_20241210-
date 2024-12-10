package com.bootcamp.bankapp.transactionservice.service;

import com.bootcamp.bankapp.transactionservice.model.Transaction;
import com.bootcamp.bankapp.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {


    @Autowired
    private TransactionRepository transactionRepository;

    public Flux<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Mono<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }

    public Mono<Transaction> save(Transaction customer) {
        return transactionRepository.save(customer);
    }

    public void deleteById(String id) {
        transactionRepository.deleteById(id);
    }

    /**
     * Performs a movements balance from specific account
     */
    public Flux<Transaction> getTransactionsByAccountId(String accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
