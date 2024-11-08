package com.matheusvsdev.picpay_challenge_resolution.projection;

import com.matheusvsdev.picpay_challenge_resolution.entity.WalletType;

import java.math.BigDecimal;

public interface WalletProjection {

    String getFullName();
    String getCpfCnpj();
    String getEmail();
    String getPassword();
    BigDecimal getBalance();
    WalletType getWalletType();
}
