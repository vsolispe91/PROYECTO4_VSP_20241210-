package com.bootcamp.bankapp.accountservice.controller;

import com.bootcamp.bankapp.accountservice.service.BalanceService;
import com.bootcamp.bankapp.accountservice.service.DebitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/balance")
public class BalanceController {


    /**
     *  Fields of Class
     */
    private static final Logger logger = LoggerFactory.getLogger(BalanceController.class);
    @Autowired
    private BalanceService balanceservice;
    /**
     * Method that return one Document by ID
     */
    @GetMapping("/balance/{id}")
    public Mono<Double> getAccountBalance(@PathVariable String id) {
        return balanceservice.getBalance(id);
    }
}
