package com.customerManagement.exceptions;

import java.io.Serial;

/**
 * Nurhasan
 */
public class CustomerNotFoundException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;
    public CustomerNotFoundException(String message){
        super(message);
    }

    @Override
    public String toString() {
        return "Invalid Customer Id ";
    }
}
