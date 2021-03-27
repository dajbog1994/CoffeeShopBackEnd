package org.example.exception;

public class CoffeeShopBackendException  extends Exception{
    private static final String MESSAGE = "Generic CoffeeShoop error";

    public CoffeeShopBackendException(){
        super(MESSAGE);
    }

    public CoffeeShopBackendException(String message){
        super(message);
    }
}
