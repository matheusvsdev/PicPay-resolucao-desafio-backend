package com.matheusvsdev.picpay_challenge_resolution.validation;

import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import com.matheusvsdev.picpay_challenge_resolution.service.AuthorizationService;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.TransferNotAuthorizedException;

public class AuthorizationValidator implements TransferValidator {

    private final AuthorizationService authorizationService;

    public AuthorizationValidator(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void validate(TransferDTO dto, Wallet sender) {
        if (!authorizationService.isAuthorized(dto)) {
            throw new TransferNotAuthorizedException("Transação não autorizada.");
        }
    }
}
