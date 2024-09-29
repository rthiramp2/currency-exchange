package com.lvadm.currency.exchange.config;

import com.lvadm.currency.exchange.dto.ErrorDetails;
import com.lvadm.currency.exchange.exception.InternalHttpClientErrorException;
import com.lvadm.currency.exchange.exception.InternalHttpServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(InternalHttpClientErrorException.class)
    public ResponseEntity<?> handleInternalHttpClientErrorException(InternalHttpClientErrorException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalHttpServerErrorException.class)
    public ResponseEntity<?> handleInternalHttpServerErrorException(InternalHttpServerErrorException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
