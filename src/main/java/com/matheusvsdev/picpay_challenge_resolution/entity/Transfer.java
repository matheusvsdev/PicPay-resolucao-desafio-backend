package com.matheusvsdev.picpay_challenge_resolution.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet_sender_id")
    private Wallet payer;

    @ManyToOne
    @JoinColumn(name = "wallet_receiver_id")
    private Wallet payee;

    private BigDecimal value;

    public Transfer() {
    }

    public Transfer(UUID id, Wallet payer, Wallet payee, BigDecimal value) {
        this.id = id;
        this.payer = payer;
        this.payee = payee;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public Wallet getPayer() {
        return payer;
    }

    public void setPayer(Wallet payer) {
        this.payer = payer;
    }

    public Wallet getPayee() {
        return payee;
    }

    public void setPayee(Wallet payee) {
        this.payee = payee;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transfer transfer = (Transfer) o;
        return Objects.equals(id, transfer.id) && Objects.equals(payer, transfer.payer) && Objects.equals(payee, transfer.payee) && Objects.equals(value, transfer.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
