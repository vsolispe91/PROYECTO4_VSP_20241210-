package com.bootcamp.bankapp.accountservice.service;

import com.bootcamp.bankapp.accountservice.repository.AccountProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TransferService {


    /**
     *  Fields of Class
     */
    @Autowired
    private AccountProductRepository toaccountRepository;

    @Autowired
    private AccountProductRepository fromAccountRepository;

    public Mono<String> transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        return toaccountRepository.findByAccountNumber(fromAccountNumber)
                .flatMap(fromAccount -> {
                    if (fromAccount.getBalance() < amount) {
                        return Mono.error(new IllegalArgumentException("Insufficient balance"));
                    }
                    fromAccount.setBalance(fromAccount.getBalance() - amount);
                    fromAccount.setTransactionCount(fromAccount.getTransactionCount() + 1);

                    return toaccountRepository.findByAccountNumber(toAccountNumber)
                            .flatMap(toAccount -> {
                                toAccount.setBalance(toAccount.getBalance() + amount);
                                fromAccountRepository.save(fromAccount);
                                return toaccountRepository.save(toAccount);
                            })
                            .then(Mono.just("Transfer successful"))
                            .onErrorResume(error -> Mono.just("Transfer failed: " + error.getMessage()));
                });
    }

}
