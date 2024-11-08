package com.matheusvsdev.picpay_challenge_resolution.tests;

import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import com.matheusvsdev.picpay_challenge_resolution.entity.WalletType;

import java.math.BigDecimal;

public class WalletFactory {

    public static Wallet createWalletCommon() {

        WalletType common = new WalletType(1L, "COMMON");

        Wallet walletCommon = new Wallet(1L, "Maria", "11111111111", "maria@example.com", "Abc123456", BigDecimal.valueOf(100.00), common);
        return walletCommon;

    }

    public static Wallet createWalletMerchant() {

        WalletType merchant = new WalletType(1L, "MERCHANT");

        Wallet walletMerchant = new Wallet(2L, "José", "2222222222", "jose@example.com", "Abc123456", BigDecimal.valueOf(100.00), merchant);
        return walletMerchant;
    }
}
