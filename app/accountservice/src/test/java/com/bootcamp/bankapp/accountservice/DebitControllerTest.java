package com.bootcamp.bankapp.accountservice;

import com.bootcamp.bankapp.accountservice.controller.DebitController;
import com.bootcamp.bankapp.accountservice.service.DebitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class DebitControllerTest {

    @Mock
    private DebitService debitService;

    @InjectMocks
    private DebitController debitController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void withdrawTest() {
        when(debitService.withdraw("1", 50.0)).thenReturn(Mono.empty());

        Mono result = debitController.withdraw("1", 50.0);
        assertNotNull(result);
    }
}
