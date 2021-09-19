create table tb_layout_cadastro (	
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome varchar(100),
	codigo BIGINT,
	centro_de_custo_id BIGINT,
	numero_campos BIGINT,
	quantide_telefones BIGINT,
	tipo int,
	status int,
	ignorar_cabecalho int,
	data_criacao DATE,
	PRIMARY KEY (id)
)engine=INNODB;