CREATE DATABASE IF NOT EXISTS sorveteria_ice_vanilla;

USE sorveteria_ice_vanilla;

CREATE TABLE clientes (
      id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
      nome VARCHAR(100),
      cpf VARCHAR(15) UNIQUE,
      email VARCHAR(100),
      celular VARCHAR(45),
      cep VARCHAR(45),
      endereco VARCHAR(100),
      numero VARCHAR(20),
      bairro VARCHAR(45),
      cidade VARCHAR(45),
      complemento VARCHAR(100),
      unidade VARCHAR(10)
);

CREATE TABLE fornecedores (
      id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
      nome VARCHAR(100),
      cnpj VARCHAR(30) UNIQUE,
      email VARCHAR(100),
      celular VARCHAR(45),
      cep VARCHAR(45),
      endereco VARCHAR(100),
      numero VARCHAR(20),
      bairro VARCHAR(45),
      cidade VARCHAR(45),
      complemento VARCHAR(100),
      unidade VARCHAR(10)
);

CREATE TABLE funcionarios (
      id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
      nome VARCHAR(100),
      cpf VARCHAR(15) UNIQUE,
      email VARCHAR(100),
      celular VARCHAR(45),
      cep VARCHAR(45),
      endereco VARCHAR(100),
      numero VARCHAR(20),
      bairro VARCHAR(45),
      cidade VARCHAR(45),
      complemento VARCHAR(100),
      unidade VARCHAR(10),
      tipo VARCHAR(30),
      cargo VARCHAR(100)
);

CREATE TABLE sorvetes (
     id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
     sabor_sorvete VARCHAR(60),
     descricao VARCHAR(100),
     categoria VARCHAR(45),
     unidade VARCHAR(10),
     quantidade INT,
     preco DOUBLE,
     data_entrada DATE,
     data_validade DATE,
     fornecedores_id INT,
     FOREIGN KEY (fornecedores_id) REFERENCES fornecedores(id)
);

CREATE TABLE vendas (
     id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
     sorvete_id INT,
     valor_total DOUBLE,
     cpf_cliente VARCHAR(15),
     forma_pagamento VARCHAR(45),
     quantidade_sorvete INT,
     data_hora DATETIME,
     FOREIGN KEY (sorvete_id) REFERENCES sorvetes(id),
     FOREIGN KEY (cpf_cliente) REFERENCES clientes(cpf)
);

CREATE TABLE usuario (
     id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
     login VARCHAR(100),
     senha VARCHAR(100),
     tipo VARCHAR(100)
);


INSERT INTO clientes (nome, cpf, email, celular, cep, endereco, numero, bairro, cidade, complemento, unidade) VALUES 
	   ('Mariana Velasquéz', '481.012.290-51', 'marianavelasquez48@gmail.com', '(18)99986-8919', '22640020', 'Avenida Armando Lombardi', 
       '1000', 'Barra da Tijuca', 'Rio de Janeiro', 'Condomínio em frente ao McDonalds', 'RJ'),
       ('Alisson Sacramento', '679.930.900-75', 'allisonsacramento67@gmail.com', '(18)99635-8368', '25674030', 'Avenida Desembargador Moreira',
       '2402', 'Ipanema', 'Rio de Janeiro', 'Posto 6 da praia de Ipanema', 'RJ'),
       ('Lívia Veloso', '832.377.570-20', 'liviaveloso83@hotmail.com', '(21)97944-3252', '22865732', 'Rua Frederico Moura',
       '118', 'Tijuca', 'Rio de Janeiro', 'Ao lado da escola municipal', 'RJ');
       
       
INSERT INTO funcionarios (nome, cpf, email, celular, cep, endereco, numero, bairro, cidade, complemento, unidade, tipo, cargo) VALUES 
       ('Lucas Medeiros Fagundes', '608.482.980-55', 'lucasmedeiros60@hotmail.com', '(42)98984-8481', '29876045', 'Rua Santo Antonio', '554',
       'Icaraí', 'Niterói', 'Ao lado da lanchonete Cartoon Lanches', 'RJ', 'Vendedor', 'Vendedor'),
       ('Viktor Kaufmann Schneider', '689.339.330-00', 'viktorkaufmann21@gmail.com', '(21)98155-2289', '22640907', 'Avenida das Américas',
       '4200', 'Barra da Tijuca', 'Rio de Janeiro', 'Em frente ao Centro Empresarial Barra Shopping', 'RJ', 'Gerente', 'Gerente'),
       ('Ana Clara Gonçalves', '726.321.570-56', 'anaclaragoncalves77@hotmail.com', '(83)97245-7187', '22710325', 'Rua das Araucárias', '47',
       'Itaipava', 'Petrópolis', 'Ao lado da Subprefeitura', 'RJ', 'Outro', 'Sorveteira');
       
INSERT INTO fornecedores (nome, cnpj, email, celular, cep, endereco, numero, bairro, cidade, complemento, unidade) VALUES 
       ('Frosty', '78.538.342/0001-57', 'frostysorvetes@gmail.com', '(11)8934-5678', '52589065', 'Avenida Parque das Rosas', '744',
       'Oliveiras', 'Brasília', 'Primeira loja à esquerda', 'DF'),
       ('Eskimó Sorvetes', '66.870.114/0001-09', 'eskimosorvetes@hotmail.com', '(54)4532-9610', '88820-000', 'Rua Vitor Meireles', '35',
       '1° de Maio', 'Içara', 'Loja localizada na BR-101', 'SC'),
       ('Froneri Sorvetes', '79.091.558/0001-80', 'fronerisorvetes@gmail.com', '(21)3419-0407', '22775-113', 'Estrada dos Bandeirantes',
       '4935', 'Jacarepaguá', 'Rio de Janeiro', 'Em frente ao Supermercados Mundial', 'RJ');
       
INSERT INTO sorvetes (sabor_sorvete, descricao, categoria, unidade, quantidade, preco, data_entrada, data_validade, fornecedores_id) VALUES 
	   ('Chocolate', 'Sorvete sabor chocolate clássico', 'Clássicos', 'litros', 35, 24.99, '2024-09-25', '2026-09-25', 1),
       ('Frutas vermelhas recheado', 'Sorvete de frutas vermelhas recheado com creme de avelã e amendoim', 'Premium', 'gramas', 30, 39.99,
       '2025-01-09', '2027-01-09', 2), 
       ('Chocolate 80% cacau', 'Sorvete diet de chocolate 80% cacau, sem adição de açúcar e baixo em calorias', 'Diet', 'gramas', 25,
       42.50, '2025-03-05', '2027-03-05', 3),
       ('Flocos', 'Sorvete de baunilha com pedaços de chocolate', 'Clássicos', 'litros', 40, 22.50, '2023-02-28', '2026-02-28', 1),
       ('Açaí diet', 'Sorvete sabor açaí, sem adição de açúcar e sem lactose', 'Diet', 'litros', 25, 29.99, '2024-12-12', '2026-12-12', 2),
       ('Cookies black recheado', 'Sorvete de cookies com chocolate meio amargo recheado com doce de leite', 'Premium', 'gramas', 20, 
       38.99, '2024-11-29', '2026-11-29', 3 );
       
INSERT INTO vendas (sorvete_id, valor_total, cpf_cliente, forma_pagamento, quantidade_sorvete, data_hora) VALUES 
       (1, 24.99, '481.012.290-51', 'Cartão de débito', 1, '2023-12-22 14:30:00'),
       (2, 79.98, '679.930.900-75', 'Cartão de crédito', 2, '2024-02-21 17:32:29'),
	   (3, 42.50, '832.377.570-20', 'Dinheiro', 1, '2024-12-24 12:45:25'),
       (4, 67.50, '481.012.290-51', 'Pix', 3, '2025-03-02 11:52:10'),
       (5, 59.98, '679.930.900-75', 'Cartão de crédito', 2, '2025-04-05 18:21:44');
       
INSERT INTO usuario (login, senha, tipo) VALUES 
       ("Viktor", "21022025", "Gerente"),
       ("Lucas", "05032025", "Vendedor");
       
SELECT * FROM clientes;
SELECT * FROM fornecedores;
SELECT * FROM funcionarios;
SELECT * FROM sorvetes;
SELECT * FROM vendas;
SELECT * FROM usuario;
