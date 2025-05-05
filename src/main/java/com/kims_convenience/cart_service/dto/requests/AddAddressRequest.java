package com.kims_convenience.cart_service.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AddAddressRequest implements WebRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String addressLine1;

    private String addressLine2;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String country;

    @NotBlank
    private String addressType;

    @NotBlank
    private boolean defaultAddress;

    @Override
    public String toLogString() {
        return String.format("AddAddressRequest[" +
                        "name=%s, " +
                        "phoneNumber=%s, " +
                        "addressLine1=%s, " +
                        "addressLine2=%s, " +
                        "city=%s, " +
                        "state=%s, " +
                        "postalCode=%s, " +
                        "country=%s, " +
                        "addressType=%s, " +
                        "defaultAddress=%s, ]",
                name,
                phoneNumber,
                addressLine1,
                addressLine2,
                city,
                state,
                postalCode,
                country,
                addressType,
                defaultAddress
        );
    }
}
