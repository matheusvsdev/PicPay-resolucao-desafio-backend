package com.matheusvsdev.picpay_challenge_resolution.validation;

import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.InsufficientBalanceException;

public class BalanceValidator implements TransferValidator {
    @Override
    public void validate(TransferDTO dto, Wallet sender) {
        if (!sender.isBalanceEqualOrGreaterThan(dto.getValue())) {
            throw new InsufficientBalanceException("Saldo insuficiente, tente um valor menor.");
        }
    }
}
