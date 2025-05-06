package com.kims_convenience.cart_service.controllers;

import com.kims_convenience.cart_service.services.OrderEventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderEventPublisher orderEventPublisher;

    @PostMapping("/{orderId}/place-order")
    public void placeOrder(@PathVariable String orderId) {
        logger.info("[placeOrder] OrderId={}", orderId);
        orderEventPublisher.submitOrder(orderId);
    }
}
