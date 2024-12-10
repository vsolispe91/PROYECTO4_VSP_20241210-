package com.bootcamp.bankapp.customer.repository;

import com.bootcamp.bankapp.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
