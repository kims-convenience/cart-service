package com.kims_convenience.cart_service.dto.order_event;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class OrderDto {

    private String orderId;
    private String customerId;
    private CartDto cart;
    private AddressDto address;
    private PaymentInstrumentDto paymentInstrument;
    private ZonedDateTime orderPlacedAt;

    public String toLogString() {
        return String.format("OrderDto[orderId=%s, customerId=%s, orderPlacedAt=%s, cart=%s, address=%s, paymentInstrument=%s]",
                orderId,
                customerId,
                orderPlacedAt != null ? orderPlacedAt.toString() : "N/A",
                cart != null ? cart.toLogString() : "N/A",
                address != null ? address.toLogString() : "N/A",
                paymentInstrument != null ? paymentInstrument.toLogString() : "N/A"
        );
    }
}
