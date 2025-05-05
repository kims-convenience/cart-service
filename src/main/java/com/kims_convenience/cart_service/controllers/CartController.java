package com.kims_convenience.cart_service.controllers;

import com.kims_convenience.cart_service.dto.cart.CartDto;
import com.kims_convenience.cart_service.dto.requests.AddItemRequest;
import com.kims_convenience.cart_service.dto.requests.CreateCartRequest;
import com.kims_convenience.cart_service.services.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @GetMapping("/cart/{cartId}")
    public ResponseEntity<CartDto> getCartById(@PathVariable String cartId) {
        logger.info("[getCartById] CartId={}", cartId);
        return ResponseEntity.ok(cartService.getCartById(cartId));
    }

    @PostMapping("/cart")
    public ResponseEntity<CartDto> createCart(@RequestBody CreateCartRequest request) {
        logger.info("[createCart] Request={}", request.toLogString());
        return ResponseEntity.ok(cartService.createCart(request));
    }

    @PutMapping("/cart/{cartId}/add-item")
    public ResponseEntity<CartDto> addItem(@PathVariable String cartId, @RequestBody AddItemRequest request) {
        logger.info("[addItem] Request={}", request.toLogString());
        return ResponseEntity.ok(cartService.addItem(cartId, request));
    }

    @PutMapping("/cart/{cartId}/update-item/{itemId}")
    public ResponseEntity<CartDto> updateItem(@PathVariable String cartId, @PathVariable String itemId, @RequestParam int quantity) {
        logger.info("[updateItem] CartId={}, ItemId={}, Quantity={}", cartId, itemId, quantity);
        return ResponseEntity.ok(cartService.updateItemQuantity(cartId, itemId, quantity));
    }

    @DeleteMapping("/cart/{cartId}/remove-item/{itemId}")
    public ResponseEntity<CartDto> removeItem(@PathVariable String cartId, @PathVariable String itemId) {
        logger.info("[removeItem] CartId={}, ItemId={}", cartId, itemId);
        return ResponseEntity.ok(cartService.removeItem(cartId, itemId));
    }
}
