package com.kims_convenience.cart_service.dto.requests;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class CreateOrderRequest implements WebRequest {

    @NonNull
    private String cartId;

    public String toLogString() {
        return String.format("CreateCartRequest[cartId=%s]", cartId);
    }
}
