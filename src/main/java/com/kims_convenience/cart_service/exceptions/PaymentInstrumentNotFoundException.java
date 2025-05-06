package com.kims_convenience.cart_service.exceptions;

public class PaymentInstrumentNotFoundException extends RuntimeException {

    public PaymentInstrumentNotFoundException(String orderId) {
        super("Payment Instrument missing for order id : " + orderId);
    }
}
