package com.matheusvsdev.picpay_challenge_resolution.repository;

import com.matheusvsdev.picpay_challenge_resolution.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
