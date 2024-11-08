package com.matheusvsdev.picpay_challenge_resolution.service;

import com.matheusvsdev.picpay_challenge_resolution.client.AuthorizationClient;
import com.matheusvsdev.picpay_challenge_resolution.client.dto.AuthorizationResponseDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationClient authorizationClient;

    public boolean isAuthorized(TransferDTO transfer) {

        ResponseEntity<AuthorizationResponseDTO> response = authorizationClient.isAuthorized();

        if (response.getStatusCode().isError()) {
            throw new DatabaseException("PicPay internal server error");
        }

        return response.getBody().isAuthorized();
    }
}
