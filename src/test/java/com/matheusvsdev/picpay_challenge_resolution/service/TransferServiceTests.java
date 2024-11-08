package com.matheusvsdev.picpay_challenge_resolution.service;

import com.matheusvsdev.picpay_challenge_resolution.dto.TransferDTO;
import com.matheusvsdev.picpay_challenge_resolution.dto.TransferResponseDTO;
import com.matheusvsdev.picpay_challenge_resolution.entity.Transfer;
import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import com.matheusvsdev.picpay_challenge_resolution.repository.TransferRepository;
import com.matheusvsdev.picpay_challenge_resolution.repository.WalletRepository;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.InsufficientBalanceException;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.ResourceNotFoundException;
import com.matheusvsdev.picpay_challenge_resolution.service.exceptions.TransferNotAuthorizedException;
import com.matheusvsdev.picpay_challenge_resolution.tests.WalletFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class TransferServiceTests {

    @InjectMocks
    private TransferService transferService;

    @Mock
    private TransferRepository transferRepository;

    @Mock
    private WalletRepository walletRepository;

    @Mock
    private NotificationService notificationService;

    @Mock
    private AuthorizationService authorizationService;

    private Wallet walletCommon, walletMerchant;

    @BeforeEach
    void setUp() {

        walletCommon = WalletFactory.createWalletCommon();
        walletMerchant = WalletFactory.createWalletMerchant();
    }

    @Test
    public void testSendTransfer() {
        // Crie um objeto mock para o TransferDTO
        TransferDTO dto = new TransferDTO(
                1L,
                2L,
                BigDecimal.valueOf(10.00));

        // Configura o objeto mock para o TransferRepository
        when(transferRepository.save(any(Transfer.class))).thenReturn(new Transfer());

        // Configura o objeto mock para o WalletRepository
        when(walletRepository.findById(1L)).thenReturn(Optional.of(walletCommon));
        when(walletRepository.findById(2L)).thenReturn(Optional.of(walletMerchant));

        // Configure o objeto mock para o AuthorizationService
        when(authorizationService.isAuthorized(any(TransferDTO.class))).thenReturn(true);

        // Chama o método sendTransfer do Transferservice
        TransferResponseDTO response = transferService.sendTransfer(dto);

        // Verifica se o método sendTransfer foi chamado corretamente
        verify(transferRepository, times(1)).save(any(Transfer.class));
        verify(walletRepository, times(2)).findById(anyLong());

        // Verifique se o response é não nulo
        assertNotNull(response);
    }

    @Test
    public void testSendTransferInsufficientBalance() {
        // Crie um objeto mock para o TransferDTO
        TransferDTO dto = new TransferDTO(
                1L,
                2L,
                BigDecimal.valueOf(1000.00));

        // Configura o objeto mock para o TransferRepository
        when(transferRepository.save(any(Transfer.class))).thenReturn(new Transfer());

        // Configura o objeto mock para o WalletRepository
        when(walletRepository.findById(1L)).thenReturn(Optional.of(walletCommon));
        when(walletRepository.findById(2L)).thenReturn(Optional.of(walletMerchant));

        // Configure o objeto mock para o AuthorizationService
        when(authorizationService.isAuthorized(any(TransferDTO.class))).thenReturn(true);

        // Chame o método sendTransfer do TransferService
        assertThrows(InsufficientBalanceException.class, () -> transferService.sendTransfer(dto));
    }

    @Test
    public void testSendTransferBeneficiaryNotFound() {

        TransferDTO dto = new TransferDTO(
                1L,
                2L,
                BigDecimal.valueOf(10.00));

        // Configure o objeto mock para o WalletRepository
        when(walletRepository.findById(1L)).thenReturn(Optional.of(walletCommon));
        when(walletRepository.findById(2L)).thenReturn(Optional.empty());

        // Chama o método sendTransfer do TransferService
        assertThrows(ResourceNotFoundException.class, () -> transferService.sendTransfer(dto));
    }

    @Test
    public void testSendTransferUnauthorized() {

        TransferDTO dto = new TransferDTO(
                1L,
                2L,
                BigDecimal.valueOf(10.00));

        // Configure o objeto mock para o WalletRepository
        when(walletRepository.findById(1L)).thenReturn(Optional.of(walletCommon));
        when(walletRepository.findById(2L)).thenReturn(Optional.of(walletMerchant));

        // Configure o objeto mock para o AuthorizationService
        when(authorizationService.isAuthorized(any(TransferDTO.class))).thenReturn(false);

        // Chame o método sendTransfer do TransferService
        assertThrows(TransferNotAuthorizedException.class, () -> transferService.sendTransfer(dto));
    }
}

