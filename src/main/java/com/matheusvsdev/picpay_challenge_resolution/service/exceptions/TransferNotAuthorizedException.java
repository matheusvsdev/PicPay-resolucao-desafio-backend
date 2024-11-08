package com.matheusvsdev.picpay_challenge_resolution.service.exceptions;

public class TransferNotAuthorizedException extends RuntimeException {

    public TransferNotAuthorizedException(String msg) {
        super(msg);
    }
}
