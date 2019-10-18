CREATE TABLE grupo_usuario (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO grupo_usuario (nome) values ('admin');
INSERT INTO grupo_usuario (nome) values ('Pedidos');
INSERT INTO grupo_usuario (nome) values ('Restaurante');