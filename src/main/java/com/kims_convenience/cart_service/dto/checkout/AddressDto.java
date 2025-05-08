package com.kims_convenience.cart_service.dto.checkout;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private Long id;
    private String addressId;
    private String name;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String addressType;
    private boolean defaultAddress;
}
