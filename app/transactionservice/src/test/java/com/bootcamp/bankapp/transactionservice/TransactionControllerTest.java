package com.bootcamp.bankapp.transactionservice;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.bootcamp.bankapp.transactionservice.controller.TransactionController;
import com.bootcamp.bankapp.transactionservice.model.Transaction;
import com.bootcamp.bankapp.transactionservice.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTransactionsTest() {
        Transaction transaction = new Transaction();
        when(transactionService.findAll()).thenReturn(Flux.just(transaction));

        Flux<Transaction> result = transactionController.getAllTransactions();
        assertNotNull(result);
    }

    @Test
    public void getTransactionByIdTest() {
        Transaction transaction = new Transaction();
        when(transactionService.findById("1")).thenReturn(Mono.just(transaction));

        Mono<Transaction> result = transactionController.getTransactionById("1");
        assertNotNull(result);
    }

    @Test
    public void createTransactionTest() {
        Transaction transaction = new Transaction();
        when(transactionService.save(transaction)).thenReturn(Mono.just(transaction));

        Mono result = transactionController.createTransaction(transaction);
        assertNotNull(result);
    }

    @Test
    public void deleteTransactionTest() {
        doNothing().when(transactionService).deleteById("1");

        transactionController.deleteTransaction("1");
        verify(transactionService, times(1)).deleteById("1");
    }

    @Test
    public void getTransactionsByAccountIdTest() {
        Transaction transaction = new Transaction();
        when(transactionService.getTransactionsByAccountId("123")).thenReturn(Flux.just(transaction));

        Flux<Transaction> result = transactionController.getTransactionsByAccountId("123");
        assertNotNull(result);
    }
}
