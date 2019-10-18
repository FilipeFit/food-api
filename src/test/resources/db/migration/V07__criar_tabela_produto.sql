CREATE TABLE produto (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(150) NOT NULL,
	valor DECIMAL(10,2) NOT NULL,
	ativo BOOLEAN NOT NULL,
	restaurante_id BIGINT(20) NOT NULL,
    FOREIGN KEY (restaurante_id) REFERENCES restaurante(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO produto (nome,descricao,valor,ativo, restaurante_id) values ('Frango assado','Frango assado no espeto',40.00,true, 1);
INSERT INTO produto (nome,descricao,valor,ativo, restaurante_id) values ('marmita carne assada','Marmita de carne assada',15.00,true,2);
INSERT INTO produto (nome,descricao,valor,ativo, restaurante_id) values ('Salada','salada fria',10.00,true, 3);

