package com.matheusvsdev.picpay_challenge_resolution.controller;

import com.matheusvsdev.picpay_challenge_resolution.dto.DepositDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.DepositResponseDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.WalletDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.WalletResponseDTO;
import com.matheusvsdev.picpay_challenge_resolution.service.WalletService;
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
@RequestMapping(value = "/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<WalletResponseDTO> createWallet(@Valid @RequestBody WalletDTO dto) {
        WalletResponseDTO wallet = walletService.createWallet(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(wallet.getId())
                .toUri();

        return ResponseEntity.created(uri).body(wallet);
    }

    @PostMapping(value = "/deposit")
    public ResponseEntity<DepositResponseDTO> deposit(@Valid @RequestBody DepositDTO dto) {
        DepositResponseDTO deposit = walletService.deposit(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(deposit.getWalletId())
                .toUri();

        return ResponseEntity.created(uri).body(deposit);
    }
}
