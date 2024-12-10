package com.bootcamp.bankapp.accountservice.controller;

import com.bootcamp.bankapp.accountservice.service.AccountProductServiceImpl;
import com.bootcamp.bankapp.accountservice.service.DebitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/debit")
public class DebitController {


    /**
     *  Fields of Class
     */
    private static final Logger logger = LoggerFactory.getLogger(DebitController.class);
    @Autowired
    private DebitService debitservice;
    /**
     * Method that update a Document by specific rule
     */
    @PutMapping("/withdraw")
    public Mono withdraw(String accountId, double amount) {
        return debitservice.withdraw(accountId,amount);
    }


}
