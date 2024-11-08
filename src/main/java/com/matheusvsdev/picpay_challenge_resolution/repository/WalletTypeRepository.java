package com.matheusvsdev.picpay_challenge_resolution.repository;

import com.matheusvsdev.picpay_challenge_resolution.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
