package com.bootcamp.bankapp.transactionservice.controller;

import com.bootcamp.bankapp.transactionservice.model.Transaction;
import com.bootcamp.bankapp.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public Flux<Transaction> getAllTransactions() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Transaction> getTransactionById(@PathVariable String id) {
        return transactionService.findById(id);
    }

    @PostMapping
    public Mono createTransaction(@RequestBody Transaction customer) {
        return transactionService.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable String id) {
        transactionService.deleteById(id);
    }

    @GetMapping("/balance/{accountId}")
    public Flux<Transaction> getTransactionsByAccountId(@PathVariable String accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }
}
