package com.kims_convenience.cart_service.dto.checkout;

import com.kims_convenience.cart_service.dto.cart.CartDto;
import com.kims_convenience.cart_service.entities.OrderStatus;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class OrderDto {

    private String id;
    private String customerId;
    private OrderStatus orderStatus;
    private ZonedDateTime updatedAt;
    private CartDto cart;
    private PaymentInstrumentDto paymentInstrument;
    private AddressDto address;
}
