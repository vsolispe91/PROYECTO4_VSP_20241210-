package com.bootcamp.bankapp.creditservice.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@Document(collection = "credits")
public class Credit {
    @Id
    private String id;

    @NonNull
    @Pattern(regexp = "PERSONAL|BUSINESS")
    private String type; // personal, business
    @NonNull
    private double amount;
    @NonNull
    private double creditLimit;
    @NonNull
    private String customerId; // ID of the customer
}
