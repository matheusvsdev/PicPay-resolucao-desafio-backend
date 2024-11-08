package com.matheusvsdev.picpay_challenge_resolution.service;

import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.TransferResponseDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.WalletResponseDTO;
import com.matheusvsdev.picpay_challenge_resolution.entity.Transfer;
import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import com.matheusvsdev.picpay_challenge_resolution.repository.TransferRepository;
import com.matheusvsdev.picpay_challenge_resolution.repository.WalletRepository;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.ResourceNotFoundException;
import com.matheusvsdev.picpay_challenge_resolution.utils.TransferValidationChain;
import com.matheusvsdev.picpay_challenge_resolution.validation.AuthorizationValidator;
import com.matheusvsdev.picpay_challenge_resolution.validation.BalanceValidator;
import com.matheusvsdev.picpay_challenge_resolution.validation.PayerAndPayeeValidator;
import com.matheusvsdev.picpay_challenge_resolution.validation.WalletTypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {

    private TransferValidationChain validationChain = new TransferValidationChain();

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private AuthorizationService authorizationService;

    @Transactional
    public TransferResponseDTO sendTransfer(TransferDTO dto) {

        Wallet sender = walletRepository.findById(dto.getPayer())
                .orElseThrow(() -> new ResourceNotFoundException("ID do remetente não encontrado."));

        Wallet receiver = walletRepository.findById(dto.getPayee())
                .orElseThrow(() -> new ResourceNotFoundException("ID do beneficiário não encontrado."));

        validateTransfer(dto, sender);

        sender.debit(dto.getValue());
        receiver.credit(dto.getValue());

        Transfer transfer = new Transfer();
        transfer.setPayer(sender);
        transfer.setPayee(receiver);
        transfer.setValue(dto.getValue());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(dto));

        return new TransferResponseDTO(transfer);
    }

    public void validateTransfer(TransferDTO dto, Wallet sender) {
        validationChain.addValidator(new WalletTypeValidator());
        validationChain.addValidator(new BalanceValidator());
        validationChain.addValidator(new AuthorizationValidator(authorizationService));
        validationChain.addValidator(new PayerAndPayeeValidator());
        validationChain.validate(dto, sender);
    }
}
