package com.kims_convenience.cart_service.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    private String id;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "payment_instrument_id", nullable = true)
    private PaymentInstrument paymentInstrument;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;
}
