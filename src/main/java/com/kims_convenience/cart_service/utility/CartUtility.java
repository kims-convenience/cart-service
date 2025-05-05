package com.kims_convenience.cart_service.utility;

import com.kims_convenience.cart_service.dto.cart.CartDto;
import com.kims_convenience.cart_service.dto.cart.LineItemDto;
import com.kims_convenience.cart_service.entities.Cart;

import java.util.List;
import java.util.stream.Collectors;

public class CartUtility {

    public static CartDto toDto(Cart cart) {
        CartDto dto = new CartDto();
        dto.setId(cart.getId());
        dto.setCustomerId(cart.getCustomerId());
        dto.setCartStatus(cart.getCartStatus());
        dto.setUpdatedAt(cart.getUpdatedAt());

        List<LineItemDto> itemDtos = cart.getLineItems().stream().map(item -> {
            LineItemDto lineDto = new LineItemDto();
            lineDto.setId(item.getId());
            lineDto.setProductId(item.getProductId());
            lineDto.setProductName(item.getProductName());
            lineDto.setSkuId(item.getSkuId());
            lineDto.setQuantity(item.getQuantity());
            lineDto.setPrice(item.getPrice());
            return lineDto;
        }).collect(Collectors.toList());

        dto.setLineItems(itemDtos);
        return dto;
    }
}
