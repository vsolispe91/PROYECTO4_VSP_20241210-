package com.bootcamp.bankapp.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * This class define a Account that contains a unique ID, type (SAVINGS, CHEKING, FIXEDDEPOSIT)
 */
@Data
public class AccountProduct implements Serializable {

    private static final long SerialVersionUID=1L;

    private String id;
    private String accountNumber;// each account must have a one (unique) number bank identification account
    private String type; // savings, checking, fixed deposit
    private double balance;
    private List<String> holders; // IDs of customers
    private List<String> authorizedSignatories; // IDs of customers
    private int monthlyTransactionLimit;
    private double maintenanceFee;
    private int transactionCount; // To track the number of transactions
}
