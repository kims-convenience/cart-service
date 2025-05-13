package com.kims_convenience.cart_service.exceptions;

public class DuplicateOrderPlacementException extends RuntimeException {

    public DuplicateOrderPlacementException(String orderId) {
        super("Duplicate order placement for order id " + orderId);
    }
}
