package com.matheusvsdev.picpay_challenge_resolution.service;

import com.matheusvsdev.picpay_challenge_resolution.client.NotificationClient;
import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private NotificationClient notificationClient;

    public void sendNotification(TransferDTO dto) {
        try {
            logger.info("Enviando notificação...");

            ResponseEntity<Void> response = notificationClient.sendNotification(dto);

            if (response.getStatusCode().isError()) {
                logger.error("Erro enquanto a notificação estava sendo enviada, status não é OK.");
            }
        } catch (Exception e) {
            logger.error("Erro enquanto a notificação estava sendo enviada.");
        }

    }
}
