package com.devfelipeamorim.cep.exceptions;

public class AddressErrorException extends Exception {
    public AddressErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressErrorException(String message) {
        super(message);
    }
}
