CREATE TABLE tags (
	Id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tags (nome)
values("Mercados");
INSERT INTO tags (nome)
values("Ifood");