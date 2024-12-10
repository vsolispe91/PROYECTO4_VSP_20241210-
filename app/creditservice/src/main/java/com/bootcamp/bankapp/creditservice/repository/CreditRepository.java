package com.bootcamp.bankapp.creditservice.repository;

import com.bootcamp.bankapp.creditservice.model.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditRepository extends ReactiveMongoRepository<Credit, String> {
}
