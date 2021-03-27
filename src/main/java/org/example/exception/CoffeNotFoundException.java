package org.example.exception;

public class CoffeNotFoundException  extends CoffeeShopBackendException{

    private static final String MESSAGE = "Coffe not found ";

    public CoffeNotFoundException(){
        super(MESSAGE);
    }
}
