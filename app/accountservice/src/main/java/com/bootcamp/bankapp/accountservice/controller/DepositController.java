package com.bootcamp.bankapp.accountservice.controller;

import com.bootcamp.bankapp.accountservice.service.AccountProductServiceImpl;
import com.bootcamp.bankapp.accountservice.service.DepositService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    /**
     *  Fields of Class
     */
    private static final Logger logger = LoggerFactory.getLogger(DepositController.class);
    @Autowired
    private DepositService depositservice;
    /**
     * Method that update a Document by specific rule
     */
    @PutMapping("/deposit")
    public Mono deposit(String accountId, double amount) {
        return depositservice.deposit(accountId,amount);
    }

}
