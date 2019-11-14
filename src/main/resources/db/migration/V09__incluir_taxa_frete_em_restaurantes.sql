ALTER TABLE restaurante ADD taxa_frete DECIMAL(10,2);

UPDATE restaurante SET taxa_frete = 0;

ALTER TABLE restaurante ALTER COLUMN  taxa_frete DECIMAL(10,2) NOT NULL;