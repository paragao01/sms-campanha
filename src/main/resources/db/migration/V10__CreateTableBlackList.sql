create table tb_blacklist (	
	id bigint(10) primary key not null AUTO_INCREMENT,
	anexo blob,
	centro_custo_id varchar(80),
	dataCadastro TimeStamp
);