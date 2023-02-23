create database agenda;

use agenda;

create table contatos(
id int auto_increment not null primary key,
nome varchar(40),
idade int,
dataCadastro date
);
