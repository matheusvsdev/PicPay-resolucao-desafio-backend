package com.matheusvsdev.picpay_challenge_resolution.dto;

import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import com.matheusvsdev.picpay_challenge_resolution.entity.WalletType;
import java.math.BigDecimal;

public class WalletResponseDTO {

    private Long id;
    private String fullName;
    private String cpfCnpj;
    private String email;
    private BigDecimal balance;
    private WalletType walletType;

    public WalletResponseDTO() {
    }

    public WalletResponseDTO(Long id,
                             String fullName,
                             String cpfCnpj,
                             String email,
                             BigDecimal balance,
                             WalletType walletType) {
        this.id = id;
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.balance = balance;
        this.walletType = walletType;
    }

    public WalletResponseDTO(Wallet entity) {
        id = entity.getId();
        fullName = entity.getFullName();
        cpfCnpj = entity.getCpfCnpj();
        email = entity.getEmail();
        balance = entity.getBalance();
        walletType = entity.getWalletType();
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public WalletType getWalletType() {
        return walletType;
    }
}
