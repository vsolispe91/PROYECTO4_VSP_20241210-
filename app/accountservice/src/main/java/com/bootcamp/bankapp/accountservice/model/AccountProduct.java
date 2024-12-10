package com.bootcamp.bankapp.accountservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * This class define a Account that contains a unique ID, type (SAVINGS, CHEKING, FIXEDDEPOSIT)
 */
@Data
@Document(collection = "accountproducts")
public class AccountProduct {

    @Id
    private String id;
    @Indexed(unique = true)
    private String accountNumber;// each account must have a one (unique) number bank identification account
    private String type; // savings, checking, fixed deposit
    private double balance;
    private List<String> holders; // IDs of customers
    private List<String> authorizedSignatories; // IDs of customers
    private int monthlyTransactionLimit;
    private double maintenanceFee;
    private int transactionCount; // To track the number of transactions
}
