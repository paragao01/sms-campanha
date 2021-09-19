drop table tb_usuario;
create table tb_usuario (	
	id int(10) PRIMARY KEY,
	nome varchar(100),
	email varchar(80),
	senha varchar(120),
	status boolean 
);