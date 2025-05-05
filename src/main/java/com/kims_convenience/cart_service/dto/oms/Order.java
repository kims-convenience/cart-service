package com.kims_convenience.cart_service.dto.oms;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class Order {

    private String orderId;
    private String customerId;
    private Cart cart;
    private Address address;
    private PaymentInstrument paymentInstrument;
    private ZonedDateTime orderPlacedAt;

    public String toLogString() {
        return String.format("Order[orderId=%s, customerId=%s, orderPlacedAt=%s, cart=%s, address=%s, paymentInstrument=%s]",
                orderId,
                customerId,
                orderPlacedAt != null ? orderPlacedAt.toString() : "N/A",
                cart != null ? cart.toLogString() : "N/A",
                address != null ? address.toLogString() : "N/A",
                paymentInstrument != null ? paymentInstrument.toLogString() : "N/A"
        );
    }
}
