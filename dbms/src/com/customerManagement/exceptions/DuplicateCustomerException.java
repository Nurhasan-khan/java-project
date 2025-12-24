package com.customerManagement.exceptions;

import java.io.Serial;

public class DuplicateCustomerException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;
    public DuplicateCustomerException(String message) {
        super(message);
    }
}
