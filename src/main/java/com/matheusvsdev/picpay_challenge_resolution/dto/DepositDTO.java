package com.matheusvsdev.picpay_challenge_resolution.dto;

import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class DepositDTO {

    private Long walletId;

    private BigDecimal amount;

    public DepositDTO() {
    }

    public DepositDTO(Long walletId,
                      BigDecimal amount) {
        this.walletId = walletId;
        this.amount = amount;
    }

    public DepositDTO(Wallet entity) {
        walletId = entity.getId();
        amount = entity.getBalance();
    }

    public Long getWalletId() {
        return walletId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
