package com.lvadm.currency.exchange.exception;

public class InternalHttpClientErrorException extends RuntimeException {
    public InternalHttpClientErrorException(String message) {
        super(message);
    }

    public InternalHttpClientErrorException(Throwable cause) {
        super(cause);
    }
}
