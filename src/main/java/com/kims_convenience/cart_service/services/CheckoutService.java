package com.kims_convenience.cart_service.services;

import com.kims_convenience.cart_service.dto.checkout.OrderDto;
import com.kims_convenience.cart_service.dto.requests.AddAddressRequest;
import com.kims_convenience.cart_service.dto.requests.AddPaymentInstrumentRequest;
import com.kims_convenience.cart_service.dto.requests.CreateOrderRequest;
import com.kims_convenience.cart_service.entities.*;
import com.kims_convenience.cart_service.exceptions.CartNotFoundException;
import com.kims_convenience.cart_service.exceptions.OrderNotFoundException;
import com.kims_convenience.cart_service.repositories.CartRepository;
import com.kims_convenience.cart_service.repositories.OrderRepository;
import com.kims_convenience.cart_service.utility.OrderUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class CheckoutService {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutService.class);

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;

    public OrderDto getOrderById(String id) {
        logger.info("[getOrderById] OrderId={}", id);
        return OrderUtility.toDto(orderRepository.findById(id).orElse(new Order()));
    }

    public OrderDto createOrder(CreateOrderRequest request) {
        logger.info("[createOrder] Request={}", request.toLogString());

        Cart cart = cartRepository.findById(request.getCartId()).orElseThrow(() -> new CartNotFoundException(request.getCartId()));

        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setCustomerId(cart.getCustomerId());
        order.setOrderStatus(OrderStatus.IN_PROGRESS);
        order.setCart(cart);
        order.setUpdatedAt(ZonedDateTime.now());
        return OrderUtility.toDto(orderRepository.save(order));
    }

    public OrderDto addPaymentInstrument(String orderId, AddPaymentInstrumentRequest request) {
        logger.info("[addPaymentInstrument] OrderId={}, Request={}", orderId, request.toLogString());

        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
        order.setPaymentInstrument(getPaymentInstrumentSnapshot(request));
        order.setUpdatedAt(ZonedDateTime.now());
        return OrderUtility.toDto(orderRepository.save(order));
    }

    public OrderDto addAddress(String orderId, AddAddressRequest request) {
        logger.info("[addAddress] OrderId={}, Request={}", orderId, request.toLogString());

        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
        order.setAddress(getAddress(request));
        order.setUpdatedAt(ZonedDateTime.now());
        return OrderUtility.toDto(orderRepository.save(order));
    }

    private PaymentInstrument getPaymentInstrumentSnapshot(AddPaymentInstrumentRequest request) {
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        paymentInstrument.setId(UUID.randomUUID().toString());
        paymentInstrument.setPaymentMethodType(request.getPaymentMethodType());
        paymentInstrument.setProvider(request.getProvider());
        paymentInstrument.setMaskedCardNumber(request.getMaskedCardNumber());
        paymentInstrument.setCardHolderName(request.getCardHolderName());
        paymentInstrument.setExpiryMonth(request.getExpiryMonth());
        paymentInstrument.setExpiryYear(request.getExpiryYear());
        paymentInstrument.setLastUsedOn(request.getLastUsedOn());
        paymentInstrument.setInstrumentToken(request.getInstrumentToken());
        return paymentInstrument;
    }

    private Address getAddress(AddAddressRequest request) {
        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setName(request.getName());
        address.setPhoneNumber(request.getPhoneNumber());
        address.setAddressLine1(request.getAddressLine1());
        address.setAddressLine2(request.getAddressLine2());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setPostalCode(request.getPostalCode());
        address.setCountry(request.getCountry());
        address.setAddressType(request.getAddressType());
        address.setDefaultAddress(request.isDefaultAddress());
        return address;
    }
}
