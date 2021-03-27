package org.example.exception;

public class CakesException extends CoffeeShopBackendException{

    private static final String MESSAGE = "Cakes Not found";

   public CakesException(){
        super(MESSAGE);
    }
}
