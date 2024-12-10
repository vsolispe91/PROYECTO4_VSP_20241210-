package com.bootcamp.bankapp.accountservice;

import com.bootcamp.bankapp.accountservice.controller.DepositController;
import com.bootcamp.bankapp.accountservice.service.DepositService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class DepositControllerTest {
    @Mock
    private DepositService depositService;

    @InjectMocks
    private DepositController depositController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void depositTest() {
        when(depositService.deposit("1", 100.0)).thenReturn(Mono.empty());

        Mono result = depositController.deposit("1", 100.0);
        assertNotNull(result);
    }
}
