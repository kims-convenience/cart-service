package com.kims_convenience.cart_service.dto.order_event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItemDto {

    private String lineItemId;
    private String productId;
    private String productName;
    private String skuId;
    private int quantity;
    private double price;

    public String toLogString() {
        return String.format("LineItem[lineItemId=%s, productId=%s, productName=%s, skuId=%s, quantity=%d, price=%.2f]",
                lineItemId, productId, productName, skuId, quantity, price);
    }
}
