package com.kims_convenience.cart_service.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "cart")
@Getter
@Setter
public class Cart {
    @Id
    private String id;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "cart_status")
    private CartStatus cartStatus;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<LineItem> lineItems = new ArrayList<>();

    @OneToOne(mappedBy = "cart", fetch = FetchType.EAGER)
    private Order order;
}
