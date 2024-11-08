package com.matheusvsdev.picpay_challenge_resolution.validation;

import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.TransferNotAllowedException;

public class PayerAndPayeeValidator implements TransferValidator {
    @Override
    public void validate(TransferDTO dto, Wallet sender) {
        if (!dto.isTransferAllowedForUserDifferent()) {
            throw new TransferNotAllowedException("Não é possível transferir dinheiro para si mesmo.");
        }
    }
}
