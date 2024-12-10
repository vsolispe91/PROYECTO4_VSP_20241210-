package com.bootcamp.bankapp.accountservice.service;

import com.bootcamp.bankapp.accountservice.model.AccountProduct;
import com.bootcamp.bankapp.accountservice.repository.AccountProductRepository;
import com.bootcamp.bankapp.accountservice.utils.AdapterExceptionHandler;
import com.bootcamp.bankapp.accountservice.utils.TransactionPredicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

/**
 * This class define a Service to implement the business rules for this microservice
 */
@Service
public class AccountProductServiceImpl  {

    /**
     *  Fields of Class
     */
    @Autowired
    private AccountProductRepository accountproductRepository;


    private static final String BANK_CODE = "444444";
    private static final long SEED = 12345L; // Semilla fija para el generador de números aleatorios
    private final Random random = new Random(SEED);

    /**
     * Method that return data related to all Documents on the Collection
     */
    public Flux<AccountProduct> findAll() {
        return accountproductRepository.findAll();
    }

    /**
     * Method that return one Document by ID
     */
    public Mono<AccountProduct> findById(String id) {
        return accountproductRepository.findById(id);
    }

    /**
     * Method that creates one Document and return it including ID
     */
    public Mono<AccountProduct> save(AccountProduct bankAccount) {
        //return accountproductRepository.save(customer);
        return generateUniqueAccountNumber()
                .flatMap(accountNumber -> {
                    bankAccount.setAccountNumber(accountNumber);
                    return accountproductRepository.save(bankAccount);
                });
    }

    /**
     * Method that delete one Document
     */
    public void deleteById(String id) {
        accountproductRepository.deleteById(id);
    }

    /**
     * Method that create a Document by specific rule, this rule consist on allow one account of any type (SAVINGS, CHECKING, FIX DEPOSIT) to Holder Client
     */
    public Mono<AccountProduct> createBankAccountPersonalType(AccountProduct bankAccount,String idCliente) {
        //String idCliente="6733cf6af54bb00c395ac98e";
        return generateUniqueAccountNumber()
                .flatMap( accountNumber -> { bankAccount.setAccountNumber(accountNumber);
                        return  accountproductRepository.findByHoldersContainsAndType(idCliente, bankAccount.getType())
                        .hasElements()
                        .flatMap(exists -> {
                            if (exists) {
                                return Mono.error(new AdapterExceptionHandler("El cliente ya tiene una cuenta bancaria de tipo " + bankAccount.getType()));
                            } else {
                                return accountproductRepository.save(bankAccount);
                            }
                        });
                });
    }

    private Mono<String> generateUniqueAccountNumber() {
        return Mono.defer(() -> {
            String accountNumber = BANK_CODE + String.format("%05d", random.nextInt(100000));
            return accountproductRepository.findByAccountNumber(accountNumber)
                    .flatMap(existing -> generateUniqueAccountNumber()) // Recur if accountNumber already exists
                    .switchIfEmpty(Mono.just(accountNumber)); // Return accountNumber if unique
        });
    }

}
