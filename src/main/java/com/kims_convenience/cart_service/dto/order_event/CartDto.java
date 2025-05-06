package com.kims_convenience.cart_service.dto.order_event;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDto {

    private String cartId;
    private List<LineItemDto> lineItems;

    public String toLogString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Cart[cartId=%s, lineItems=[", cartId));
        if (lineItems != null) {
            for (LineItemDto item : lineItems) {
                sb.append(item.toLogString()).append(", ");
            }
        }
        sb.append("]]");
        return sb.toString();
    }
}
