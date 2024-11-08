INSERT INTO tb_wallet_type (type) VALUES ('COMMON');
INSERT INTO tb_wallet_type (type) VALUES ('MERCHANT');

INSERT INTO tb_wallet (full_name, cpf_cnpj, email, password, balance, wallet_type_id) VALUES ('José', '11111111111', 'jose@example.com', 'Abc123456', 100.00, 1);
INSERT INTO tb_wallet (full_name, cpf_cnpj, email, password, balance, wallet_type_id) VALUES ('Maria', '22222222222', 'maria@example.com', 'Abc123456', 100.00, 2);
