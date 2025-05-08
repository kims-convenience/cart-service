package com.kims_convenience.cart_service.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_id")
    private String addressId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "address_type")
    private String addressType;

    @Column(name = "default_address")
    private boolean defaultAddress;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}

