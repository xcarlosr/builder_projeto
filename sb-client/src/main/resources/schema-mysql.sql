CREATE DATABASE IF NOT EXISTS `builder`;

use builder;

CREATE TABLE IF NOT EXISTS `builder`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NULL,
  `idade` VARCHAR(3) NULL,
  `data_cadastro` DATE NULL,
  PRIMARY KEY (`id`));
ENGINE = InnoDB;

INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Rafael', 'rafael@gmail.com', '21', NOW());
INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Bezerra', 'bezerra@bol.com.br', '35', NOW());
INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Flavio', 'flavio@terra.com.br', '28', NOW());
INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Ana', 'ana@gmail.com', '22', NOW());
INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Beatriz', 'beatriz@bol.com.br', '32', NOW());
INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Flavia', 'flavia@terra.com.br', '28', NOW());
INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Raquel', 'raquel@gmail.com', '20', NOW());
INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Alvaro', 'alvaroa@bol.com.br', '18', NOW());
INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Carlos', 'carlos@terra.com.br', '19', NOW());
INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Julia', 'julia@gmail.com', '23', NOW());
INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Eidan', 'Eidan@bol.com.br', '25', NOW());
INSERT INTO client (nome, email, idade, data_cadastro) VALUES ('Erika', 'erika@terra.com.br', '38', NOW());