package com.bootcamp.bankapp.service;

import com.bootcamp.bankapp.apisclient.AccountProductClient;
import com.bootcamp.bankapp.apisclient.CustomerClient;
import com.bootcamp.bankapp.model.AccountProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class AffiliationService {


    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private AccountProductClient accountProductClient;

    public Mono<Void> processPersonalCustomer(String customerId, AccountProduct accountProduct) {
        return customerClient.getCustomerById(customerId)
                .flatMap(customer -> {
                    if ("PERSONAL".equalsIgnoreCase(customer.getType())) {
                        return accountProductClient.createBankAccountPersonalType(accountProduct, customerId).then();
                    }
                    return Mono.empty();
                });
    }
}
