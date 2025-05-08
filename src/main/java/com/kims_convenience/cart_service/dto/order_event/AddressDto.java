package com.kims_convenience.cart_service.dto.order_event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

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

    public String toLogString() {
        return String.format("Address[addressId=%s, name=%s, phone=%s, addressLine1=%s, addressLine2=%s, city=%s, state=%s, postalCode=%s, country=%s, type=%s, defaultAddress=%s]",
                addressId, name, phoneNumber, addressLine1, addressLine2, city, state, postalCode, country, addressType, defaultAddress);
    }
}
