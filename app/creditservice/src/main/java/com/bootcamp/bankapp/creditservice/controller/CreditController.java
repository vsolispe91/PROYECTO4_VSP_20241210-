package com.bootcamp.bankapp.creditservice.controller;

import com.bootcamp.bankapp.creditservice.model.Credit;
import com.bootcamp.bankapp.creditservice.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping
    public Flux<Credit> getAllCredits() {
        return creditService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Credit> getCreditById(@Valid @PathVariable String id) {
        return creditService.findById(id);
    }

    @PostMapping
    public Mono createCredit(@Valid @RequestBody Credit customer) {
        return creditService.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable String id) {
        creditService.deleteById(id);
    }

    /**
     * Method that update a Document by specific rule
     */
    @PutMapping("/consume")
    public Mono consumption(@RequestBody String id, double consumptionAmount) {
        return creditService.consumeCredit(id,consumptionAmount);
    }
    /**
     * Method that update a Document by specific rule
     */
    @PutMapping("/pay")
    public Mono payment(@RequestBody String id, double paymentAmoun) {
        return creditService.makePayment(id,paymentAmoun);
    }
}
