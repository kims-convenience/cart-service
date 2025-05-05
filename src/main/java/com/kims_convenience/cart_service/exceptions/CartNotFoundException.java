package com.kims_convenience.cart_service.exceptions;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(String id) {
        super("Cart not found with id : " + id);
    }
}
