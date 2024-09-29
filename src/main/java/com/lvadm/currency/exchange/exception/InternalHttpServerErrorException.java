package com.lvadm.currency.exchange.exception;

public class InternalHttpServerErrorException extends RuntimeException {
    public InternalHttpServerErrorException(String message) {
        super(message);
    }

    public InternalHttpServerErrorException(Throwable cause) {
        super(cause);
    }
}
