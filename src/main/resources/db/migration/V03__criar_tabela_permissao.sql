CREATE TABLE permissao (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO permissao (nome, descricao) values ('Cadastro Cidade', 'Permissão para Cadastro de Cidades');
INSERT INTO permissao (nome, descricao) values ('Cadastro Estado', 'Permissão para Cadastro de Estados');
INSERT INTO permissao (nome, descricao) values ('Pesquisa Cidade', 'Permissão para Pesquisa de Cidades');