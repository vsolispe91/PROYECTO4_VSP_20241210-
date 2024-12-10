package com.bootcamp.bankapp.transactionservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String type; // deposit, withdrawal, payment, charge
    private double amount;
    private Date date;
    private String accountId; // ID of the bank account
    private String creditId; // ID of the credit
}
