package com.kims_convenience.cart_service.services;

import com.kims_convenience.cart_service.dto.CartDto;
import com.kims_convenience.cart_service.entities.Cart;
import com.kims_convenience.cart_service.repositories.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    @Autowired
    private CartRepository cartRepository;

    public CartDto getCartById(String id) {
        logger.info("getCartById::" + id);
        return CartDto.getCartDto(cartRepository.findById(id).orElse(new Cart()));
    }

    public CartDto saveCart(CartDto cartDto) {
        logger.info("saveCart::" + cartDto.toString());
        return CartDto.getCartDto(cartRepository.save(CartDto.getCart(cartDto)));
    }
}
