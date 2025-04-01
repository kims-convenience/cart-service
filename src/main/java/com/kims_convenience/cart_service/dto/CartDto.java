package com.kims_convenience.cart_service.dto;

import com.kims_convenience.cart_service.entities.Cart;
import com.kims_convenience.cart_service.entities.CartStatus;
import com.kims_convenience.cart_service.entities.LineItem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CartDto {

    private String id;
    private String customerId;
    private CartStatus cartStatus;
    private List<LineItemDto> lineItems;

    public static Cart getCart(CartDto request) {
        Cart cart = new Cart();
        cart.setCustomerId(request.customerId);
        cart.setLineItems(addCartToLineItems(LineItemDto.getLineItems(request.lineItems), cart));
        cart.setCartStatus(request.cartStatus);
        return cart;
    }

    public static CartDto getCartDto(Cart cart) {
        CartDto dto = new CartDto();
        dto.setId(cart.getId());
        dto.setCustomerId(cart.getCustomerId());
        dto.setLineItems(LineItemDto.getLineItemsDto(cart.getLineItems()));
        dto.setCartStatus(cart.getCartStatus());
        return dto;
    }

    private static List<LineItem> addCartToLineItems(List<LineItem> lineItems, Cart cart) {
        lineItems.forEach(li -> li.setCart(cart));
        return lineItems;
    }
}
