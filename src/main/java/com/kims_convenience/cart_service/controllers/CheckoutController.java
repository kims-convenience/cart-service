package com.kims_convenience.cart_service.controllers;

import com.kims_convenience.cart_service.dto.checkout.OrderDto;
import com.kims_convenience.cart_service.dto.requests.AddAddressRequest;
import com.kims_convenience.cart_service.dto.requests.AddPaymentInstrumentRequest;
import com.kims_convenience.cart_service.dto.requests.CreateOrderRequest;
import com.kims_convenience.cart_service.services.CheckoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("orderId") String orderId) {
        logger.info("[getOrderById] OrderId={}", orderId);
        return ResponseEntity.ok(checkoutService.getOrderById(orderId));
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody CreateOrderRequest request) {
        logger.info("[createOrder] Request={}", request.toLogString());
        return ResponseEntity.ok(checkoutService.createOrder(request));
    }

    @PostMapping("/{orderId}/add-payment")
    public ResponseEntity<OrderDto> addPayment(@PathVariable String orderId,
                                               @RequestBody AddPaymentInstrumentRequest request) {
        logger.info("[addPayment] OrderId={}, Request={}", orderId, request.toLogString());
        return ResponseEntity.ok(checkoutService.addPaymentInstrument(orderId, request));
    }

    @PostMapping("/{orderId}/add-address")
    public ResponseEntity<OrderDto> addAddress(@PathVariable String orderId,
                                               @RequestBody AddAddressRequest request) {
        logger.info("[addAddress] OrderId={}, Request={}", orderId, request.toLogString());
        return ResponseEntity.ok(checkoutService.addAddress(orderId, request));
    }
}
