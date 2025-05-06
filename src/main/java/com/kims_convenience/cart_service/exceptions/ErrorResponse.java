package com.kims_convenience.cart_service.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ErrorResponse {
    
    private final String code;
    private final String message;
}
