package com.matheusvsdev.picpay_challenge_resolution.tests;

import com.matheusvsdev.picpay_challenge_resolution.entity.WalletType;
import com.matheusvsdev.picpay_challenge_resolution.projection.WalletProjection;

import java.math.BigDecimal;

public class WalletImpl implements WalletProjection {

    private String fullName;
    private String cpfCnpj;
    private String email;
    private String password;
    private BigDecimal balance;
    private WalletType walletType;

    public WalletImpl() {
    }

    public WalletImpl(String fullName, String cpfCnpj, String email, String password, BigDecimal balance, WalletType walletType) {
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.walletType = walletType;
    }



    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public WalletType getWalletType() {
        return walletType;
    }
}
