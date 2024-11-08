package com.matheusvsdev.picpay_challenge_resolution.validation;

import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;

public interface TransferValidator {
    void validate(TransferDTO dto, Wallet sender);
}
