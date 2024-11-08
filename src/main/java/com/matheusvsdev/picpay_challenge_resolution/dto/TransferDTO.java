package com.matheusvsdev.picpay_challenge_resolution.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheusvsdev.picpay_challenge_resolution.entity.Transfer;
import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class TransferDTO {

    private UUID id;

    private Long payer;

    private Long payee;

    @DecimalMin(message = "Valor não permitido, tente um valor mínimo de 0.01", value = "0.01")
    @NotNull(message = "Campo requerido")
    private BigDecimal value;

    public TransferDTO() {
    }

    public TransferDTO(UUID id, Long payer, Long payee, BigDecimal value) {
        this.id = id;
        this.payer = payer;
        this.payee = payee;
        this.value = value;
    }

    public TransferDTO(Transfer entity) {
        id = entity.getId();
        payer = entity.getPayer().getId();
        payee = entity.getPayee().getId();
        value = entity.getValue();
    }

    public TransferDTO(Long payer, Long payee, BigDecimal value) {
        this.payer = payer;
        this.payee = payee;
        this.value = value;
    }

    public boolean isTransferAllowedForUserDifferent() {
        return !this.payer.equals(this.payee);
    }

    public UUID getId() {
        return id;
    }

    public Long getPayer() {
        return payer;
    }

    public Long getPayee() {
        return payee;
    }

    public BigDecimal getValue() {
        return value;
    }
}
