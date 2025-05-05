package com.kims_convenience.cart_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "payment_instrument")
@Getter
@Setter
public class PaymentInstrument {
    @Id
    private String id;

    @Column(name = "payment_method_type", nullable = false)
    private String paymentMethodType;

    @Column(name = "provider")
    private String provider;

    @Column(name = "masked_card_number")
    private String maskedCardNumber;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "expiry_month")
    private String expiryMonth;

    @Column(name = "expiry_year")
    private String expiryYear;

    @Column(name = "last_used_on")
    private String lastUsedOn;

    @Column(name = "instrument_token")
    private String instrumentToken;
}
