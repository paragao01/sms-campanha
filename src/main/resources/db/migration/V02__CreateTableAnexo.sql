create table tb_anexo (	
	id int(10) NOT NULL AUTO_INCREMENT,
	nome varchar(100),
	tamanho_arquivo int,
	url varchar(200),
	PRIMARY KEY (id)
)engine=INNODB;