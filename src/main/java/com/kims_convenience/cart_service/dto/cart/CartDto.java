package com.kims_convenience.cart_service.dto.cart;

import com.kims_convenience.cart_service.entities.CartStatus;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class CartDto {

    private String id;
    private String customerId;
    private CartStatus cartStatus;
    private List<LineItemDto> lineItems;
    private ZonedDateTime updatedAt;
}
