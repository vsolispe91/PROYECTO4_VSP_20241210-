package com.bootcamp.bankapp.accountservice.service;

import com.bootcamp.bankapp.accountservice.model.AccountProduct;
import com.bootcamp.bankapp.accountservice.repository.AccountProductRepository;
import com.bootcamp.bankapp.accountservice.utils.TransactionPredicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DepositService {


    /**
     *  Fields of Class
     */
    @Autowired
    private AccountProductRepository depositRepository;
    /**
     * Performs a deposit for an account, and returns updated account.
     */
    public Mono<AccountProduct> deposit(String accountId, double amount) {
        return depositRepository.findById(accountId)
                .flatMap(account -> {
                    account.setTransactionCount(account.getTransactionCount() + 1);
                    if (TransactionPredicates.exceedsTransactionLimit.test(account)) {
                        account.setBalance(account.getBalance() - TransactionPredicates.TRANSACTION_FEE);
                    }
                    account.setBalance(account.getBalance() + amount);
                    return depositRepository.save(account);
                });
    }
}
