package com.kims_convenience.cart_service.mappers;

import com.kims_convenience.cart_service.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "cart", target = "cart")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "paymentInstrument", target = "paymentInstrument")
    @Mapping(source = "updatedAt", target = "orderPlacedAt")
    com.kims_convenience.cart_service.dto.oms.Order toOmsOrder(Order order);

    @Mapping(source = "id", target = "cartId")
    @Mapping(source = "lineItems", target = "lineItems")
    com.kims_convenience.cart_service.dto.oms.Cart toOmsCart(Cart cart);

    @Mapping(source = "id", target = "lineItemId")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "skuId", target = "skuId")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    com.kims_convenience.cart_service.dto.oms.LineItem toOmsLineItem(LineItem lineItem);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "addressLine1", target = "addressLine1")
    @Mapping(source = "addressLine2", target = "addressLine2")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "state", target = "state")
    @Mapping(source = "postalCode", target = "postalCode")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "addressType", target = "addressType")
    @Mapping(source = "defaultAddress", target = "defaultAddress")
    com.kims_convenience.cart_service.dto.oms.Address toOmsCart(Address address);

    @Mapping(source = "paymentMethodType", target = "paymentMethodType")
    @Mapping(source = "provider", target = "provider")
    @Mapping(source = "maskedCardNumber", target = "maskedCardNumber")
    @Mapping(source = "cardHolderName", target = "cardHolderName")
    @Mapping(source = "expiryMonth", target = "expiryMonth")
    @Mapping(source = "expiryYear", target = "expiryYear")
    @Mapping(source = "instrumentToken", target = "instrumentToken")
    @Mapping(source = "lastUsedOn", target = "lastUsedOn")
    com.kims_convenience.cart_service.dto.oms.PaymentInstrument toOmsCart(PaymentInstrument paymentInstrument);
}
