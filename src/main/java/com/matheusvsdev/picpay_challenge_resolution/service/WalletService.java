package com.matheusvsdev.picpay_challenge_resolution.service;

import com.matheusvsdev.picpay_challenge_resolution.dto.DepositDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.DepositResponseDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.WalletDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.WalletResponseDTO;
import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import com.matheusvsdev.picpay_challenge_resolution.entity.WalletType;
import com.matheusvsdev.picpay_challenge_resolution.repository.WalletRepository;
import com.matheusvsdev.picpay_challenge_resolution.repository.WalletTypeRepository;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.ArgumentAlreadyExistsException;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.InvalidAmountException;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletTypeRepository walletTypeRepository;

    public WalletResponseDTO createWallet(WalletDTO dto) {
        Wallet wallet = new Wallet();
        assigningDtoToEntities(wallet, dto);

        emailAndCpfCnpjValidation(dto);

        wallet = walletRepository.save(wallet);

        return new WalletResponseDTO(wallet);
    }

    @Transactional
    public DepositResponseDTO deposit(DepositDTO dto) {
        Wallet wallet = walletRepository.findById(dto.getWalletId())
                .orElseThrow(() -> new ResourceNotFoundException("ID da carteira não encontrado."));

        BigDecimal amount = dto.getAmount();
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Valor do depósito precisa ser maior que 0.");
        }

        wallet.deposit(amount);
        wallet = walletRepository.save(wallet);

        return new DepositResponseDTO(wallet);

    }

    private void emailAndCpfCnpjValidation(WalletDTO dto) {
        if (walletRepository.existsByCpfCnpj(dto.getCpfCnpj())) {
            throw new ArgumentAlreadyExistsException("CPF/CNPJ já cadastrado");
        }
        if (walletRepository.existsByEmail(dto.getEmail())) {
            throw new ArgumentAlreadyExistsException("Email já cadastrado");
        }
    }

    public void assigningDtoToEntities(Wallet entity, WalletDTO dto) {
        entity.setFullName(dto.getFullName());
        entity.setCpfCnpj(dto.getCpfCnpj());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());

        WalletType walletType = walletTypeRepository.findById(dto.getWalletTypeId()).orElseThrow(() -> new ResourceNotFoundException("WalletTypeId não encontrado."));

        entity.setWalletType(walletType);
    }

}
