package com.kims_convenience.cart_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "address")
@Getter
@Setter
public class Address {
    @Id
    private String id;

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

    public String getFullAddress() {
        return String.format("%s, %s, %s, %s - %s, %s",
                addressLine1,
                addressLine2 != null ? addressLine2 : "",
                city,
                state,
                postalCode,
                country);
    }
}

