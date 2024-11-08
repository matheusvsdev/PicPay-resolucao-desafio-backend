package com.matheusvsdev.picpay_challenge_resolution.service.exceptions;

public class TransferNotAllowedException extends RuntimeException {

    public TransferNotAllowedException(String msg) {
        super(msg);
    }
}
