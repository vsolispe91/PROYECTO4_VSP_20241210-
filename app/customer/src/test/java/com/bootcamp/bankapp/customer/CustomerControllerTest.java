package com.bootcamp.bankapp.customer;

import com.bootcamp.bankapp.customer.controller.CustomerController;
import com.bootcamp.bankapp.customer.model.Customer;
import com.bootcamp.bankapp.customer.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CustomerControllerTest     {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllCustomersTest() {
        Customer customer = new Customer();
        when(customerService.findAll()).thenReturn(Flux.just(customer));

        Flux<Customer> result = customerController.getAllCustomers();
        assertNotNull(result);
    }

    @Test
    public void getCustomerByIdTest() {
        Customer customer = new Customer();
        when(customerService.findById("1")).thenReturn(Mono.just(customer));

        Mono<Customer> result = customerController.getCustomerById("1");
        assertNotNull(result);
    }

    @Test
    public void createCustomerTest() {
        Customer customer = new Customer();
        when(customerService.save(customer)).thenReturn(Mono.just(customer));

        Mono result = customerController.createCustomer(customer);
        assertNotNull(result);
    }

    @Test
    public void deleteCustomerTest() {
        doNothing().when(customerService).deleteById("1");

        customerController.deleteCustomer("1");
        verify(customerService, times(1)).deleteById("1");
    }
}
