package com.bootcamp.bankapp.accountservice.controller;

import com.bootcamp.bankapp.accountservice.model.AccountProduct;
import com.bootcamp.bankapp.accountservice.model.ErrorResponse;
import com.bootcamp.bankapp.accountservice.service.AccountProductServiceImpl;
import com.bootcamp.bankapp.accountservice.utils.AdapterExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class define all controller methods for this microservice
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    /**
     *  Fields of Class
     */
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountProductServiceImpl accountproductService;
    /**
     * Method that return data related to all Documents on the Collection
     */
    @GetMapping
    public Flux<AccountProduct> getAllAccounts() {
        logger.info("Obteniendo Cuentas");
        return accountproductService.findAll();
    }

    /**
     * Method that return one Document by ID
     */
    @GetMapping("/{id}")
    public Mono<AccountProduct> getAccountById(@PathVariable String id) {
        return accountproductService.findById(id);
    }

    /**
     * Method that creates one Document and return it including ID
     */
    @PostMapping
    public Mono createAccount(@RequestBody AccountProduct account) {
        return accountproductService.save(account);
    }
    /**
     * Method that delete one Document
     */
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountproductService.deleteById(id);
    }
    /**
     * Method that create a Document by specific rule
     */
    @PostMapping("/personal/{id}")
    public Mono createBankAccountPersonalType(@RequestBody AccountProduct account, @PathVariable String id) {
        return accountproductService.createBankAccountPersonalType(account,id);
    }

    /**
     * Method that Handle Exception for specific case
     */
    @ExceptionHandler(AdapterExceptionHandler.class)
    public Mono<ResponseEntity<ErrorResponse>> handleAccountTypeAlreadyExistsException(AdapterExceptionHandler ex) {
        return Mono.just(new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST));
    }
}
