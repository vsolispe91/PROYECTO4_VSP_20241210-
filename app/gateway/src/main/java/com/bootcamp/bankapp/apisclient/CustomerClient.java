package com.bootcamp.bankapp.apisclient;

import com.bootcamp.bankapp.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient(name = "CUSTOMERSERVICE")
public interface CustomerClient {

    @GetMapping("/customers/{id}")
    Mono<Customer> getCustomerById(@PathVariable String id);
}
