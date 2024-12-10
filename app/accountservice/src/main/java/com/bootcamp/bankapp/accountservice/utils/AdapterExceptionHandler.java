package com.bootcamp.bankapp.accountservice.utils;

public class AdapterExceptionHandler extends RuntimeException{
    public AdapterExceptionHandler(String mensaje){
        super(mensaje);
    }
}
