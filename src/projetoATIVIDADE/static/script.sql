create database if not exists db01;
use db01;
create table produto (
    id int primary key auto_increment,
    codigo int not null unique,
    nome varchar (150) not null,
    marca varchar (150) not null,
    tipo varchar (150) not null
);

select * from produto;