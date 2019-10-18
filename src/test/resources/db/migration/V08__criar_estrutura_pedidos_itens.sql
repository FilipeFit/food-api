CREATE TABLE forma_pagamento (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO forma_pagamento(descricao) values ('Dinheiro');
INSERT INTO forma_pagamento(descricao) values ('Cartão de crédito');
INSERT INTO forma_pagamento(descricao) values ('Cartão de débito');

CREATE TABLE pedido (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    sub_total DECIMAL(10,2) NOT NULL,
	taxa_frete DECIMAL(10,2) NOT NULL,
	valor_total DECIMAL(10,2) NOT NULL,
	data_criacao DATE NOT NULL,
	data_confirmacao DATE,
	data_entrega DATE,
	data_cancelamento DATE,
	status_pedido VARCHAR(30) NOT NULL,
	forma_pagamento_id BIGINT(20) NOT NULL,
	endereco_id BIGINT(20) NOT NULL,
	FOREIGN KEY (forma_pagamento_id) REFERENCES forma_pagamento(id),
	FOREIGN KEY (endereco_id) REFERENCES endereco(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE item_pedido (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	quantidade BIGINT(20) NOT NULL,
	preco_unitario DECIMAL(10,2) NOT NULL,
	preco_total DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(150),
	id_pedido BIGINT(20) NOT NULL,
	id_produto BIGINT(20) NOT NULL,
	FOREIGN KEY (id_pedido) REFERENCES pedido(id),
	FOREIGN KEY (id_produto) REFERENCES produto(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pedido (sub_total,taxa_frete,valor_total, data_criacao, data_confirmacao, data_entrega, data_cancelamento, status_pedido, forma_pagamento_id, endereco_id) values (100.0,10.50,110.50,'2019-10-10','2019-10-10',null,'2019-10-11','CANCELADO',1,1);
INSERT INTO pedido (sub_total,taxa_frete,valor_total, data_criacao, data_confirmacao, data_entrega, data_cancelamento, status_pedido, forma_pagamento_id, endereco_id) values (100.0,10.50,110.50,'2019-10-10','2019-10-10','2019-10-15',null,'ENTREGUE',2,2);
INSERT INTO pedido (sub_total,taxa_frete,valor_total, data_criacao, data_confirmacao, data_entrega, data_cancelamento, status_pedido, forma_pagamento_id, endereco_id) values (100.0,10.50,110.50,'2019-10-10','2019-10-10',null,null,'CONFIRMADO',3,3);
INSERT INTO pedido (sub_total,taxa_frete,valor_total, data_criacao, data_confirmacao, data_entrega, data_cancelamento, status_pedido, forma_pagamento_id, endereco_id) values (100.0,10.50,110.50,'2019-10-10',null,null,null,'CRIADO',2,1);

INSERT INTO item_pedido (quantidade,preco_unitario,preco_total, observacao, id_pedido, id_produto) values (10,10.00,100.00,'Sem tempero', 1,1);
INSERT INTO item_pedido (quantidade,preco_unitario,preco_total, observacao, id_pedido, id_produto) values (5,15.00,75.00,null, 2,2);
INSERT INTO item_pedido (quantidade,preco_unitario,preco_total, observacao, id_pedido, id_produto) values (5,15.00,75.00,'Pequena', 3,3);