CREATE TABLE usuario (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL,
	grupo_usuario_id BIGINT(20) NOT NULL,
	FOREIGN KEY (grupo_usuario_id) REFERENCES grupo_usuario(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (nome,email,senha,grupo_usuario_id) values ('Filipe','filipe@teste.com','123',1);
INSERT INTO usuario (nome,email,senha,grupo_usuario_id) values ('teste','teste@teste.com','123',2);
INSERT INTO usuario (nome,email,senha,grupo_usuario_id) values ('teste 1','teste1@teste.com','123',3);