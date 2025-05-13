package com.kims_convenience.cart_service.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCartNotFound(CartNotFoundException ex) {
        logger.warn("[handleCartNotFound] Exception : {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("CART_NOT_FOUND", ex.getMessage()));
    }

    @ExceptionHandler(InvalidLineItemException.class)
    public ResponseEntity<ErrorResponse> handleInvalidItem(InvalidLineItemException ex) {
        logger.warn("[handleInvalidItem] Exception : {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("INVALID_LINE_ITEM", ex.getMessage()));
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOrderNotFound(OrderNotFoundException ex) {
        logger.warn("[handleOrderNotFound] Exception : {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("ORDER_NOT_FOUND", ex.getMessage()));
    }

    @ExceptionHandler(DuplicateOrderCreationException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateOrderCreation(DuplicateOrderCreationException ex) {
        logger.warn("[handleDuplicateOrderCreation] Exception : {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("DUPLICATE_ORDER_CREATION", ex.getMessage()));
    }

    @ExceptionHandler(DuplicateOrderPlacementException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateOrderPlacement(DuplicateOrderPlacementException ex) {
        logger.warn("[handleDuplicateOrderPlacement] Exception : {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("DUPLICATE_ORDER_PLACEMENT", ex.getMessage()));
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAddressNotFound(AddressNotFoundException ex) {
        logger.warn("[handleAddressNotFound] Exception : {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("ADDRESS_MISSING", ex.getMessage()));
    }

    @ExceptionHandler(PaymentInstrumentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePaymentInstrumentNotFound(PaymentInstrumentNotFoundException ex) {
        logger.warn("[handlePaymentInstrumentNotFound] Exception : {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("PAYMENT_INSTRUMENT_MISSING", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {
        logger.warn("[handleGeneral] Exception : {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("INTERNAL_ERROR", "An unexpected error occurred."));
    }
}
