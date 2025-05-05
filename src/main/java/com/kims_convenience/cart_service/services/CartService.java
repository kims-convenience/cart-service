package com.kims_convenience.cart_service.services;

import com.kims_convenience.cart_service.dto.cart.CartDto;
import com.kims_convenience.cart_service.dto.requests.AddItemRequest;
import com.kims_convenience.cart_service.dto.requests.CreateCartRequest;
import com.kims_convenience.cart_service.entities.Cart;
import com.kims_convenience.cart_service.entities.CartStatus;
import com.kims_convenience.cart_service.entities.LineItem;
import com.kims_convenience.cart_service.exceptions.CartNotFoundException;
import com.kims_convenience.cart_service.repositories.CartRepository;
import com.kims_convenience.cart_service.utility.CartUtility;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public CartDto createCart(CreateCartRequest request) {
        logger.info("[createCart] Request={}", request.toLogString());

        Cart cart = new Cart();
        cart.setId(UUID.randomUUID().toString());
        cart.setCustomerId(request.getCustomerId());
        cart.setCartStatus(CartStatus.ACTIVE);
        cart.setUpdatedAt(ZonedDateTime.now());

        List<LineItem> items = request.getLineItems().stream().map(dto -> {
            LineItem item = new LineItem();
            item.setId(UUID.randomUUID().toString());
            item.setProductId(dto.getProductId());
            item.setProductName(dto.getProductName());
            item.setSkuId(dto.getSkuId());
            item.setQuantity(dto.getQuantity());
            item.setPrice(dto.getPrice());
            item.setCart(cart);
            return item;
        }).collect(Collectors.toList());

        cart.setLineItems(items);

        Cart savedCart = cartRepository.save(cart);
        return CartUtility.toDto(savedCart);
    }

    @Transactional
    public CartDto addItem(String cartId, AddItemRequest request) {
        logger.info("[addItem] CartId={}, Request={}", cartId, request.toLogString());

        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));

        List<LineItem> toAdd = request.getLineItems().stream().map(dto -> {
            LineItem item = new LineItem();
            item.setId(UUID.randomUUID().toString());
            item.setProductId(dto.getProductId());
            item.setProductName(dto.getProductName());
            item.setSkuId(dto.getSkuId());
            item.setQuantity(dto.getQuantity());
            item.setPrice(dto.getPrice());
            item.setCart(cart);
            return item;
        }).toList();

        cart.getLineItems().addAll(toAdd);
        cart.setUpdatedAt(ZonedDateTime.now());
        return CartUtility.toDto(cartRepository.save(cart));
    }

    @Transactional
    public CartDto updateItemQuantity(String cartId, String itemId, int quantity) {
        logger.info("[updateItemQuantity] CartId={}, ItemId={}, Quantity={}", cartId, itemId, quantity);

        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));
        cart.getLineItems()
                .stream()
                .filter(li -> li.getId().equals(itemId))
                .forEach(li -> li.setQuantity(quantity));

        cart.setUpdatedAt(ZonedDateTime.now());
        return CartUtility.toDto(cartRepository.save(cart));
    }

    @Transactional
    public CartDto removeItem(String cartId, String itemId) {
        logger.info("[removeItem] CartId={}, ItemId={}", cartId, itemId);

        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));

        List<LineItem> lineItemsUpdated = cart.getLineItems()
                .stream()
                .filter(li -> !li.getId().equals(itemId)).toList();

        // When using orphanRemoval=true, JPA expects the same collection instance.
        cart.getLineItems().clear();    // Clear the old list
        cart.getLineItems().addAll(lineItemsUpdated);   // Add updated items.

        return CartUtility.toDto(cartRepository.save(cart));
    }

    public CartDto getCartById(String id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(id));
        return CartUtility.toDto(cart);
    }
}
