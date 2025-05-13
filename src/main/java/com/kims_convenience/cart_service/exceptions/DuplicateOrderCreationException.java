package com.kims_convenience.cart_service.exceptions;

public class DuplicateOrderCreationException extends RuntimeException {

    public DuplicateOrderCreationException(String cartId) {
        super("Duplicate order creation for cart id " + cartId);
    }
}
