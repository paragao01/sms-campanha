drop table tb_usuario;
create table tb_usuario (	
	id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome varchar(100) DEFAULT NULL,
	email varchar(80) DEFAULT NULL,
	senha varchar(120) DEFAULT NULL,
	status boolean 
);