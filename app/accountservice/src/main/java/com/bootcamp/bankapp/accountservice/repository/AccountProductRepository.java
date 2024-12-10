package com.bootcamp.bankapp.accountservice.repository;

import com.bootcamp.bankapp.accountservice.model.AccountProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class define Mongo Reactive Repository to handle the persistence on NOSQL database
 */
public interface AccountProductRepository extends ReactiveMongoRepository<AccountProduct, String> {
    /**
     * Method that implements a rule to create a specific document
     */
    Flux<AccountProduct> findByHoldersContainsAndType(String holderId, String type);


    Mono<AccountProduct> findByAccountNumber(String accountNumber);


}
