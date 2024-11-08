package com.matheusvsdev.picpay_challenge_resolution.utils;

import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import com.matheusvsdev.picpay_challenge_resolution.validation.TransferValidator;

import java.util.ArrayList;
import java.util.List;

public class TransferValidationChain {

    private List<TransferValidator> validators = new ArrayList<>();

    public void addValidator(TransferValidator validator) {
        validators.add(validator);
    }

    public void validate(TransferDTO dto, Wallet sender) {
        for (TransferValidator validator : validators) {
            validator.validate(dto, sender);
        }
    }
}
