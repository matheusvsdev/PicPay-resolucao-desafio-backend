package com.matheusvsdev.picpay_challenge_resolution.client.dto;

public class AuthorizationResponseDTO {

    private boolean authorized;

    public AuthorizationResponseDTO() {
    }

    public AuthorizationResponseDTO(boolean authorized) {
        this.authorized = authorized;
    }

    public boolean isAuthorized() {
        return authorized;
    }
}
