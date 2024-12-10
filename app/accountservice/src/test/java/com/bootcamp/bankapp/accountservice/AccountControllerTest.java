package com.bootcamp.bankapp.accountservice;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.reactive.server.WebTestClient.bindToController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.bootcamp.bankapp.accountservice.controller.AccountController;
import com.bootcamp.bankapp.accountservice.model.AccountProduct;
import com.bootcamp.bankapp.accountservice.model.ErrorResponse;
import com.bootcamp.bankapp.accountservice.service.AccountProductServiceImpl;
import com.bootcamp.bankapp.accountservice.utils.AdapterExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Arrays;

public class AccountControllerTest {


    @Mock
    private AccountProductServiceImpl accountProductService;

    @InjectMocks
    private AccountController accountController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllAccountsTest() {
        AccountProduct accountProduct = new AccountProduct();
        when(accountProductService.findAll()).thenReturn(Flux.just(accountProduct));

        Flux<AccountProduct> result = accountController.getAllAccounts();
        assertNotNull(result);
    }

    @Test
    public void getAccountByIdTest() {
        AccountProduct accountProduct = new AccountProduct();
        when(accountProductService.findById("1")).thenReturn(Mono.just(accountProduct));

        Mono<AccountProduct> result = accountController.getAccountById("1");
        assertNotNull(result);
    }

    @Test
    public void createAccountTest() {
        AccountProduct accountProduct = new AccountProduct();
        when(accountProductService.save(accountProduct)).thenReturn(Mono.just(accountProduct));

        Mono result = accountController.createAccount(accountProduct);
        assertNotNull(result);
    }

    @Test
    public void deleteAccountTest() {
        doNothing().when(accountProductService).deleteById("1");

        accountController.deleteAccount("1");
        verify(accountProductService, times(1)).deleteById("1");
    }

    @Test
    public void createBankAccountPersonalTypeTest() {
        AccountProduct accountProduct = new AccountProduct();
        when(accountProductService.createBankAccountPersonalType(accountProduct, "1")).thenReturn(Mono.just(accountProduct));

        Mono result = accountController.createBankAccountPersonalType(accountProduct, "1");
        assertNotNull(result);
    }

    @Test
    public void handleAccountTypeAlreadyExistsExceptionTest() {
        AdapterExceptionHandler exception = new AdapterExceptionHandler("Account type already exists");
        Mono<ResponseEntity<ErrorResponse>> result = accountController.handleAccountTypeAlreadyExistsException(exception);
        assertEquals(HttpStatus.BAD_REQUEST, result.block().getStatusCode());
    }

}
