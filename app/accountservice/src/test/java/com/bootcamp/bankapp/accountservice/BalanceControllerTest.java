package com.bootcamp.bankapp.accountservice;

import com.bootcamp.bankapp.accountservice.controller.BalanceController;
import com.bootcamp.bankapp.accountservice.service.BalanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BalanceControllerTest {

    @Mock
    private BalanceService balanceService;

    @InjectMocks
    private BalanceController balanceController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAccountBalanceTest() {
        when(balanceService.getBalance("1")).thenReturn(Mono.just(100.0));

        Mono<Double> result = balanceController.getAccountBalance("1");
        assertEquals(100.0, result.block());
    }
}
