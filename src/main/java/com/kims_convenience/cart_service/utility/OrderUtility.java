package com.kims_convenience.cart_service.utility;

import com.kims_convenience.cart_service.dto.checkout.AddressDto;
import com.kims_convenience.cart_service.dto.checkout.OrderDto;
import com.kims_convenience.cart_service.dto.checkout.PaymentInstrumentDto;
import com.kims_convenience.cart_service.entities.Address;
import com.kims_convenience.cart_service.entities.Order;
import com.kims_convenience.cart_service.entities.PaymentInstrument;

public class OrderUtility {

    public static OrderDto toDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setCustomerId(order.getCustomerId());
        dto.setCart(CartUtility.toDto(order.getCart()));
        dto.setAddress(order.getAddress() == null ? null : toDto(order.getAddress()));
        dto.setPaymentInstrument(order.getPaymentInstrument() == null ? null : toDto(order.getPaymentInstrument()));
        dto.setOrderStatus(order.getOrderStatus());
        dto.setUpdatedAt(order.getUpdatedAt());
        return dto;
    }

    public static AddressDto toDto(Address address) {
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setName(address.getName());
        dto.setPhoneNumber(address.getPhoneNumber());
        dto.setAddressLine1(address.getAddressLine1());
        dto.setAddressLine2(address.getAddressLine2());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setPostalCode(address.getPostalCode());
        dto.setCountry(address.getCountry());
        dto.setAddressType(address.getAddressType());
        dto.setDefaultAddress(address.isDefaultAddress());
        return dto;
    }

    public static PaymentInstrumentDto toDto(PaymentInstrument paymentInstrument) {
        PaymentInstrumentDto dto = new PaymentInstrumentDto();
        dto.setId(paymentInstrument.getId());
        dto.setPaymentMethodType(paymentInstrument.getPaymentMethodType());
        dto.setProvider(paymentInstrument.getProvider());
        dto.setMaskedCardNumber(paymentInstrument.getMaskedCardNumber());
        dto.setCardHolderName(paymentInstrument.getCardHolderName());
        dto.setExpiryMonth(paymentInstrument.getExpiryMonth());
        dto.setExpiryYear(paymentInstrument.getExpiryYear());
        dto.setLastUsedOn(paymentInstrument.getLastUsedOn());
        dto.setInstrumentToken(paymentInstrument.getInstrumentToken());
        return dto;
    }
}
