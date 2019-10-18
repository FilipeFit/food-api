CREATE TABLE cidade (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	estado_id BIGINT(20) NOT NULL,
	FOREIGN KEY (estado_id) REFERENCES estado(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cidade (nome, estado_id) values ('Campinas', 1);
INSERT INTO cidade (nome, estado_id) values ('Belo Horizonte', 2);
INSERT INTO cidade (nome, estado_id) values ('São Paulo', 1);
INSERT INTO cidade (nome, estado_id) values ('Florianopolis', 4);
INSERT INTO cidade (nome, estado_id) values ('Salvador', 3);