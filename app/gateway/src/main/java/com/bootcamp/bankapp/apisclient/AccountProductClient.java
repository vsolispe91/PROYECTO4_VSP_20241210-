package com.bootcamp.bankapp.apisclient;


import com.bootcamp.bankapp.model.AccountProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@FeignClient(name = "ACCOUNTSERVICE")
public interface AccountProductClient {

    @PostMapping("/accounts/personal/{id}")
    Mono<AccountProduct> createBankAccountPersonalType(@RequestBody AccountProduct account, @PathVariable String id);
}
