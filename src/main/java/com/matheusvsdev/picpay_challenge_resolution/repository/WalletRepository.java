package com.matheusvsdev.picpay_challenge_resolution.repository;

import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    boolean existsByCpfCnpj(String cpfCnpj);
    boolean existsByEmail(String email);

}
