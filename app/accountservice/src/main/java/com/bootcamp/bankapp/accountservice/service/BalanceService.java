package com.bootcamp.bankapp.accountservice.service;

import com.bootcamp.bankapp.accountservice.model.AccountProduct;
import com.bootcamp.bankapp.accountservice.repository.AccountProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BalanceService {


    /**
     *  Fields of Class
     */
    @Autowired
    private AccountProductRepository balanceRepository;

    /**
     * Performs an account balance
     */
    public Mono<Double> getBalance(String accountId) {
        return balanceRepository.findById(accountId)
                .map(AccountProduct::getBalance);
    }
}
