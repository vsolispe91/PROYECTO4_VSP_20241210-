package com.bootcamp.bankapp.accountservice.utils;

import com.bootcamp.bankapp.accountservice.model.AccountProduct;

import java.util.function.Predicate;

public class TransactionPredicates {

    public static final double TRANSACTION_FEE = 5.0; // Ejemplo de monto de la comisión

    public static Predicate<AccountProduct> exceedsTransactionLimit = account ->
            account.getTransactionCount() > account.getMonthlyTransactionLimit();

}
