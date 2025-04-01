package com.kims_convenience.cart_service.controllers;

import com.kims_convenience.cart_service.dto.CartDto;
import com.kims_convenience.cart_service.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/cart/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable("id") String id) {
        return ResponseEntity.ok(cartService.getCartById(id));
    }

    @PostMapping("/cart")
    public ResponseEntity<CartDto> createCart(@RequestBody CartDto cartDto) {
        return ResponseEntity.ok(cartService.saveCart(cartDto));
    }

    @PutMapping("/cart/{id}")
    public ResponseEntity<CartDto> updateCart(@PathVariable("id") String id, @RequestBody CartDto cartDto) {
        return ResponseEntity.ok(cartService.saveCart(cartDto));
    }
}
