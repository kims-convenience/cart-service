package com.kims_convenience.cart_service.dto.cart;

import lombok.Data;


@Data
public class LineItemDto {

    private String id;
    private String productId;
    private String productName;
    private String skuId;
    private int quantity;
    private double price;
}
