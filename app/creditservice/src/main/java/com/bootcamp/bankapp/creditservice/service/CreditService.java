package com.bootcamp.bankapp.creditservice.service;

import com.bootcamp.bankapp.creditservice.model.Credit;
import com.bootcamp.bankapp.creditservice.repository.CreditRepository;
import com.bootcamp.bankapp.creditservice.utils.AdapterExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    public Flux<Credit> findAll() {
        return creditRepository.findAll();
    }

    public Mono<Credit> findById(String id) {
        return creditRepository.findById(id);
    }

    public Mono<Credit> save(Credit customer) {
        return creditRepository.save(customer);
    }

    public void deleteById(String id) {
        creditRepository.deleteById(id);
    }
    /**
     * Performs a consume by credit account.
     */
    public Mono<Credit> consumeCredit(String id, double consumptionAmount) {
        return creditRepository.findById(id)
                .flatMap(credit -> {
                    double newAmount = credit.getAmount() + consumptionAmount;
                    if (newAmount <= credit.getCreditLimit()) {
                        credit.setAmount(newAmount);
                        return creditRepository.save(credit);
                    } else {
                        return Mono.error(new AdapterExceptionHandler("Consumption exceeds the credit limit for the account: " + id));
                    }
                });
    }

    /**
     * Performs a payment to credit account.
     */
    public Mono<Credit> makePayment(String id, double paymentAmount) {
        return creditRepository.findById(id)
                .flatMap(credit -> {
                    if (paymentAmount > 0) {
                        credit.setAmount(credit.getAmount() - paymentAmount);
                        return creditRepository.save(credit);
                    } else {
                        return Mono.error(new AdapterExceptionHandler("The amount to be paid must be greater than zero: " + paymentAmount));
                    }
                });
    }
}
