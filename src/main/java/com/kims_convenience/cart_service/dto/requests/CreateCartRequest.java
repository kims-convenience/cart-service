package com.kims_convenience.cart_service.dto.requests;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CreateCartRequest implements WebRequest {

    private String customerId;
    private List<LineItemRequest> lineItems;

    public String toLogString() {
        String lineItemsStr = lineItems == null ? "null" :
                lineItems.stream()
                        .map(LineItemRequest::toLogString)
                        .collect(Collectors.joining(", ", "[", "]"));
        return String.format("CreateCartRequest[customerId=%s, lineItems=%s]", customerId, lineItemsStr);
    }
}