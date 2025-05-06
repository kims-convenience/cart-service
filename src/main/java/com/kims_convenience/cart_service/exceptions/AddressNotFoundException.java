package com.kims_convenience.cart_service.exceptions;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(String orderId) {
        super("Address missing for order id : " + orderId);
    }
}
