package com.matheusvsdev.picpay_challenge_resolution.dto;

import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import com.matheusvsdev.picpay_challenge_resolution.entity.WalletType;

import java.math.BigDecimal;

public class DepositResponseDTO {

    private Long walletId;
    private String fullName;
    private String cpfCnpj;
    private BigDecimal balance;

    public DepositResponseDTO() {
    }

    public DepositResponseDTO(Long walletId,
                              String fullName,
                              String cpfCnpj,
                              BigDecimal balance) {
        this.walletId = walletId;
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.balance = balance;
    }

    public DepositResponseDTO(Wallet entity) {
        walletId = entity.getId();
        fullName = entity.getFullName();
        cpfCnpj = entity.getCpfCnpj();
        balance = entity.getBalance();
    }

    public Long getWalletId() {
        return walletId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
