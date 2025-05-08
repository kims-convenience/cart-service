package com.kims_convenience.cart_service.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AddPaymentInstrumentRequest implements WebRequest {

    @NotBlank
    private String orderId;

    @NotBlank
    private String paymentInstrumentId;

    @NotBlank
    private String paymentMethodType;

    @NotBlank
    private String provider;

    @NotBlank
    private String maskedCardNumber;

    @NotBlank
    private String cardHolderName;

    @NotBlank
    private String expiryMonth;

    @NotBlank
    private String expiryYear;

    @NotBlank
    private String lastUsedOn;

    @NotBlank
    private String instrumentToken;

    @Override
    public String toLogString() {
        return String.format("AddPaymentRequest[" +
                        "orderId=%s, " +
                        "paymentInstrumentId=%s, " +
                        "paymentMethodType=%s, " +
                        "provider=%s, " +
                        "maskedCardNumber=%s, " +
                        "cardHolderName=%s, " +
                        "expiryMonth=%s, " +
                        "expiryYear=%s, " +
                        "lastUsedOn=%s, " +
                        "instrumentToken=%s, ]",
                orderId,
                paymentInstrumentId,
                paymentMethodType,
                provider,
                maskedCardNumber,
                cardHolderName,
                expiryMonth,
                expiryYear,
                lastUsedOn,
                instrumentToken
        );
    }
}
