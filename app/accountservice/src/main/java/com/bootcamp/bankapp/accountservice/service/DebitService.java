package com.bootcamp.bankapp.accountservice.service;

import com.bootcamp.bankapp.accountservice.model.AccountProduct;
import com.bootcamp.bankapp.accountservice.repository.AccountProductRepository;
import com.bootcamp.bankapp.accountservice.utils.TransactionPredicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * This class define a Service to implement the business rules for this microservice
 */
@Service
public class DebitService {


    /**
     *  Fields of Class
     */
    @Autowired
    private AccountProductRepository debitRepository;
    /**
     * Performs a withdrawal from an account, and returns updated account
     */
    public Mono<AccountProduct> withdraw(String accountId, double amount) {
        return debitRepository.findById(accountId)
                .flatMap(account -> {
                    account.setTransactionCount(account.getTransactionCount() + 1);
                    if (TransactionPredicates.exceedsTransactionLimit.test(account)) {
                        account.setBalance(account.getBalance() - TransactionPredicates.TRANSACTION_FEE);
                    }
                    double newBalance = account.getBalance() - amount;
                    if (newBalance < 0) {
                        return Mono.error(new IllegalArgumentException("Insufficient funds for withdrawal"));
                    }
                    account.setBalance(newBalance);
                    return debitRepository.save(account);
                });
    }
}
