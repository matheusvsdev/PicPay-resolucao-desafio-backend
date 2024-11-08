package com.matheusvsdev.picpay_challenge_resolution.client;

import com.matheusvsdev.picpay_challenge_resolution.client.dto.AuthorizationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AuthorizationClient",
                url = "${client.authorization-service.url}")
public interface AuthorizationClient {

    @GetMapping
    ResponseEntity<AuthorizationResponseDTO> isAuthorized();
}
