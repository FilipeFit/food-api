CREATE TABLE endereco (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	cep VARCHAR(20) NOT NULL,
	logradouro VARCHAR(150) NOT NULL,
	numero VARCHAR(13) NOT NULL,
	complemento VARCHAR(50),
	bairro VARCHAR(100) NOT NULL,
	cidade_id BIGINT(20) NOT NULL,
	FOREIGN KEY (cidade_id) REFERENCES cidade(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO endereco (cep,logradouro,numero,complemento,bairro, cidade_id) values ('13466110', 'Rua Tupinambas', '21', 'casa terrea', 'nova americana', 1);
INSERT INTO endereco (cep,logradouro,numero,complemento,bairro, cidade_id) values ('13466110', 'Rua Tupinambas', '21', null, 'nova americana', 2);
INSERT INTO endereco (cep,logradouro,numero,complemento,bairro, cidade_id) values ('13466110', 'Rua Tupinambas', '21', null, 'nova americana', 3);

CREATE TABLE cozinha (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cozinha(nome) values ('Japonesa');
INSERT INTO cozinha(nome) values ('Chinesa');
INSERT INTO cozinha(nome) values ('Brasileira');

CREATE TABLE restaurante (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	ativo BOOLEAN NOT NULL,
	aberto BOOLEAN NOT NULL,
	data_cadastro DATE NOT NULL,
	data_atualizacao DATE NOT NULL,
	cozinha_id BIGINT(20) NOT NULL,
	endereco_id BIGINT(20) NOT NULL,
	FOREIGN KEY (cozinha_id) REFERENCES cozinha(id),
	FOREIGN KEY (endereco_id) REFERENCES endereco(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO restaurante (nome,ativo,aberto,data_cadastro, data_atualizacao, cozinha_id, endereco_id) values ('Cozinha legal',true, true, '2019-10-10', '2019-10-10', 1,1);
INSERT INTO restaurante (nome,ativo,aberto,data_cadastro, data_atualizacao, cozinha_id, endereco_id) values ('Cozinha legal 2',true, true, '2019-10-10', '2019-10-10', 2,3);
INSERT INTO restaurante (nome,ativo,aberto,data_cadastro, data_atualizacao, cozinha_id, endereco_id) values ('Cozinha legal 3',true, true, '2019-10-10', '2019-10-10', 2,3);