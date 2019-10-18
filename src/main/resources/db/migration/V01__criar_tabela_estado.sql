CREATE TABLE estado (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO estado (nome) values ('São Paulo');
INSERT INTO estado (nome) values ('Minas Gerais');
INSERT INTO estado (nome) values ('Bahia');
INSERT INTO estado (nome) values ('Rio Grande do Sul');
INSERT INTO estado (nome) values ('Mato Grosso');