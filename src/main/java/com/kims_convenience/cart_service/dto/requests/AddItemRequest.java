package com.kims_convenience.cart_service.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AddItemRequest implements WebRequest {

    @NotBlank
    private String cartId;

    @NotNull
    private List<LineItemRequest> lineItems;


    public String toLogString() {
        String lineItemsStr = lineItems == null ? "null" :
                lineItems.stream()
                        .map(LineItemRequest::toLogString)
                        .collect(Collectors.joining(", ", "[", "]"));
        return String.format("AddItemRequest[cartId=%s, lineItems=%s]", cartId, lineItemsStr);
    }

}
