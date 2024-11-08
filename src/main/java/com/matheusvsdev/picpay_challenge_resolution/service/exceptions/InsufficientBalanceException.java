package com.matheusvsdev.picpay_challenge_resolution.service.exceptions;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
