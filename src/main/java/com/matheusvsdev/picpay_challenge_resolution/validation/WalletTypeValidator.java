package com.matheusvsdev.picpay_challenge_resolution.validation;

import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.TransferNotAllowedException;

public class WalletTypeValidator implements TransferValidator {
    @Override
    public void validate(TransferDTO dto, Wallet sender) {
        if (!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedException("Esse tipo de carteira " + sender.getWalletType() + " não é válida para transferência.");
        }
    }
}
