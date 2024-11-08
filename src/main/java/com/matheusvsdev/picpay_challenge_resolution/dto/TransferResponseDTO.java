package com.matheusvsdev.picpay_challenge_resolution.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheusvsdev.picpay_challenge_resolution.entity.Transfer;
import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class TransferResponseDTO {

    private UUID id;

    private WalletResponseDTO payer;

    private WalletResponseDTO payee;

    private BigDecimal value;

    public TransferResponseDTO() {
    }

    public TransferResponseDTO(UUID id, WalletResponseDTO payer, WalletResponseDTO payee, BigDecimal value) {
        this.id = id;
        this.payer = payer;
        this.payee = payee;
        this.value = value;
    }

    public TransferResponseDTO(Transfer entity) {
        id = entity.getId();
        payer = new WalletResponseDTO(entity.getPayer());
        payee = new WalletResponseDTO(entity.getPayee());
        value = entity.getValue();
    }

    public UUID getId() {
        return id;
    }

    public WalletResponseDTO getPayer() {
        return payer;
    }

    public WalletResponseDTO getPayee() {
        return payee;
    }

    public BigDecimal getValue() {
        return value;
    }
}
