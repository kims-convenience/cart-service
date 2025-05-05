package com.kims_convenience.cart_service.dto.oms;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart {

    private String cartId;
    private List<LineItem> lineItems;

    public String toLogString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Cart[cartId=%s, lineItems=[", cartId));
        if (lineItems != null) {
            for (LineItem item : lineItems) {
                sb.append(item.toLogString()).append(", ");
            }
        }
        sb.append("]]");
        return sb.toString();
    }
}
