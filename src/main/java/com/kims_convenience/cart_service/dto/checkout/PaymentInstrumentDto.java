package com.kims_convenience.cart_service.dto.checkout;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentInstrumentDto {

    private String id;
    private String paymentMethodType;
    private String provider;
    private String maskedCardNumber;
    private String cardHolderName;
    private String expiryMonth;
    private String expiryYear;
    private String lastUsedOn;
    private String instrumentToken;
}
