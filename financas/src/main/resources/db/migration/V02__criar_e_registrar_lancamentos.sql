CREATE TABLE lancamentos (
	Id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	valor DECIMAL(10,2) NOT NULL,
	data DATE,
	tag_id BIGINT(20) NOT NULL,
	is_Pago INT,
	FOREIGN KEY (tag_id) REFERENCES tags(Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamentos (nome, valor, data, tag_id, is_Pago)
values("Dia",25, '2021-02-02', 1, 0);
INSERT INTO lancamentos (nome, valor, data, tag_id, is_Pago)
values("Habibs",50, '2021-01-02', 2, 1);