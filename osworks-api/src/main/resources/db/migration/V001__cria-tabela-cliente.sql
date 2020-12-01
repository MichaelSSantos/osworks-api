create table cliente (
	id bigint primary key auto_increment,
    nome varchar(60) not null,
    email varchar(255) not null,
    telefone varchar(20) not null
)