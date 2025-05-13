package com.kims_convenience.cart_service.exceptions;

public class InvalidLineItemException extends RuntimeException {
    public InvalidLineItemException(String reason) {
        super("Invalid line item : " + reason);
    }
}
