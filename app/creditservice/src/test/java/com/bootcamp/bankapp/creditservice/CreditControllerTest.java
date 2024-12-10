package com.bootcamp.bankapp.creditservice;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.bootcamp.bankapp.creditservice.controller.CreditController;
import com.bootcamp.bankapp.creditservice.model.Credit;
import com.bootcamp.bankapp.creditservice.service.CreditService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreditControllerTest {

    @Mock
    private CreditService creditService;

    @InjectMocks
    private CreditController creditController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllCreditsTest() {
        Credit credit = new Credit();
        when(creditService.findAll()).thenReturn(Flux.just(credit));

        Flux<Credit> result = creditController.getAllCredits();
        assertNotNull(result);
    }

    @Test
    public void getCreditByIdTest() {
        Credit credit = new Credit();
        when(creditService.findById("1")).thenReturn(Mono.just(credit));

        Mono<Credit> result = creditController.getCreditById("1");
        assertNotNull(result);
    }

    @Test
    public void createCreditTest() {
        Credit credit = new Credit();
        when(creditService.save(credit)).thenReturn(Mono.just(credit));

        Mono result = creditController.createCredit(credit);
        assertNotNull(result);
    }

    @Test
    public void deleteCreditTest() {
        doNothing().when(creditService).deleteById("1");

        creditController.deleteCredit("1");
        verify(creditService, times(1)).deleteById("1");
    }

    @Test
    public void consumptionTest() {
        Credit credit = new Credit();
        when(creditService.consumeCredit("1", 100.0)).thenReturn(Mono.just(credit));

        Mono result = creditController.consumption("1", 100.0);
        assertNotNull(result);
    }

    @Test
    public void paymentTest() {
        Credit credit = new Credit();
        when(creditService.makePayment("1", 50.0)).thenReturn(Mono.just(credit));

        Mono result = creditController.payment("1", 50.0);
        assertNotNull(result);
    }
}
