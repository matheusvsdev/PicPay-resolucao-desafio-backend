package com.matheusvsdev.picpay_challenge_resolution.client;

import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "NotificationClient",
        url = "${client.notification-service.url}")
public interface NotificationClient {

    @PostMapping
    ResponseEntity<Void> sendNotification(TransferDTO dto);
}
