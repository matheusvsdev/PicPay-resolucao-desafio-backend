package com.matheusvsdev.picpay_challenge_resolution.dto;

import com.matheusvsdev.picpay_challenge_resolution.entity.Wallet;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class WalletDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "Mínimo 3 caracteres")
    private String fullName;

    @Column(unique = true)
    @NotBlank(message = "Campo requerido")
    private String cpfCnpj;

    @Column(unique = true)
    @NotBlank(message = "Campo requerido")
    @Pattern(regexp = ".+@.+\\..+", message = "Email deve ter um domínio válido")
    private String email;

    @NotBlank(message = "Campo requerido")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,}$"
            , message = "Senha deve ter pelo menos 8 caracteres, incluindo uma letra maiúscula, uma letra minúscula e um número")
    private String password;

    @NotNull(message = "Campo requerido")
    private Long walletTypeId;

    public WalletDTO() {
    }

    public WalletDTO(Long id, String fullName, String cpfCnpj, String email, String password, Long walletTypeId) {
        this.id = id;
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.walletTypeId = walletTypeId;
    }

    public WalletDTO(Wallet entity) {
        id = entity.getId();
        fullName = entity.getFullName();
        cpfCnpj = entity.getCpfCnpj();
        email = entity.getEmail();
        password = entity.getPassword();
        walletTypeId = entity.getWalletType().getId();
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getWalletTypeId() {
        return walletTypeId;
    }
}
