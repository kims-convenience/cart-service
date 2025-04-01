package com.kims_convenience.cart_service.dto;

import com.kims_convenience.cart_service.entities.LineItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LineItemDto {

    private String id;
    private String productId;
    private String skuId;
    private int quantity;
    private double price;

    static List<LineItem> getLineItems(List<LineItemDto> request) {
        return request.stream().map(LineItemDto::getLineItem).collect(Collectors.toList());

    }
    static LineItem getLineItem(LineItemDto request) {
        LineItem lineItem = new LineItem();
        lineItem.setProductId(request.productId);
        lineItem.setSkuId(request.skuId);
        lineItem.setQuantity(request.quantity);
        lineItem.setPrice(request.price);
        return lineItem;
    }

    static List<LineItemDto> getLineItemsDto(List<LineItem> lineItems) {
        return lineItems.stream().map(LineItemDto::getLineItemDto).collect(Collectors.toList());

    }
    static LineItemDto getLineItemDto(LineItem lineItem) {
        LineItemDto dto = new LineItemDto();
        dto.setId(lineItem.getId());
        dto.setProductId(lineItem.getProductId());
        dto.setSkuId(lineItem.getSkuId());
        dto.setQuantity(lineItem.getQuantity());
        dto.setPrice(lineItem.getPrice());
        return dto;
    }
}
