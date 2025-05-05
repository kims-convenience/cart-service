package com.kims_convenience.cart_service.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LineItemRequest implements WebRequest {

    @NotBlank
    private String productId;

    @NotBlank
    private String productName;

    @NotBlank
    private String skuId;

    @NotNull
    private int quantity;

    @NotBlank
    private double price;

    public String toLogString() {
        return String.format("LineItemRequest[productId=%s, productName=%s, skuId=%s, quantity=%d, price=%.2f]",
                this.productId,
                this.productName,
                this.skuId,
                this.quantity,
                this.price);
    }
}
