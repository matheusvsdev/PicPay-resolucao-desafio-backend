package com.matheusvsdev.picpay_challenge_resolution.controller;

import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.TransferResponseDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.WalletResponseDTO;
import com.matheusvsdev.picpay_challenge_resolution.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity<TransferResponseDTO> sendTransfer(@Valid @RequestBody TransferDTO dto) {
        TransferResponseDTO transfer = transferService.sendTransfer(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(transfer.getId())
                .toUri();

        return ResponseEntity.created(uri).body(transfer);
    }
}
