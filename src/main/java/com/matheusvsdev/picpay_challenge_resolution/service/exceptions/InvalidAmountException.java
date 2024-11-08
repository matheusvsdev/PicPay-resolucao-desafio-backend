package com.matheusvsdev.picpay_challenge_resolution.service.exceptions;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(String msg) {
        super(msg);
    }
}
