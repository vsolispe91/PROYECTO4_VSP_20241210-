package com.bootcamp.bankapp.controller;


import com.bootcamp.bankapp.model.AccountProduct;
import com.bootcamp.bankapp.service.AffiliationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * This class define all controller methods for this microservice
 */
@RestController
@RequestMapping("/affliatemanager")
public class AffiliationManager {


    private static final Logger logger = LoggerFactory.getLogger(AffiliationManager.class);
    @Autowired
    private AffiliationService affiliationservice;
    /**
     * Method that creates one Document and return it including ID
     */
    @PostMapping("/process/{customerId}")
    public Mono<Void> processCustomer(@PathVariable String customerId, @RequestBody AccountProduct accountProduct) {
        return affiliationservice.processPersonalCustomer(customerId, accountProduct);
    }

}
