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

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private PaymentInstrument paymentInstrument;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Address address;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    public void setPaymentInstrument(PaymentInstrument paymentInstrument) {
        if (this.paymentInstrument != null) {
            // Unlink from the order
            this.paymentInstrument.setOrder(null);
        }

        this.paymentInstrument = paymentInstrument;

        if (paymentInstrument != null) {
            // Link to the order
            paymentInstrument.setOrder(this);
        }
    }

    public void setAddress(Address address) {
        if (this.address != null) {
            // Unlink from the order
            this.address.setOrder(null);
        }

        this.address = address;

        if (address != null) {
            // Link to the order
            address.setOrder(this);
        }
    }
}
