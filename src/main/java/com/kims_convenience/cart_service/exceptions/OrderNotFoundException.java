package com.kims_convenience.cart_service.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String id) {
        super("Order not found with id : " + id);
    }
}
