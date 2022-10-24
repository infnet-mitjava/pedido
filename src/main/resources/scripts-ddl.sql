-- Cração das tabelas do projeto
-- Tipos no mysql https://dev.mysql.com/doc/refman/8.0/en/data-types.html
-- https://www.w3resource.com/sql/sql-syntax.php
-- https://java-design-patterns.com/patterns/dao/#explanation

drop database app;

create table cliente(
	codigo int not null primary key auto_increment,
	nome varchar(80)
)


create table produto(
	codigo int not null primary key auto_increment,
	descricao varchar(120),
	preco double
)

select * from cliente;


insert into produto (codigo,  descricao, preco) values (null, 'Arroz a bolonheza', 100);




