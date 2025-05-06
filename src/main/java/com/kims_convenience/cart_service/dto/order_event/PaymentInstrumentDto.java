package com.kims_convenience.cart_service.dto.order_event;

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

    public String toLogString() {
        return String.format("PaymentInstrument[id=%s, type=%s, provider=%s, maskedCard=%s, holder=%s, expiry=%s/%s, lastUsedOn=%s, token=%s]",
                id,
                paymentMethodType,
                provider,
                maskedCardNumber,
                cardHolderName,
                expiryMonth,
                expiryYear,
                lastUsedOn,
                instrumentToken != null ? instrumentToken.substring(0, Math.min(6, instrumentToken.length())) + "..." : "N/A"
        );
    }
}
