CREATE TABLE tb_grupo (
	id bigint not null auto_increment, 
	nome varchar(255) not null, 
	PRIMARY KEY (id)
)engine=INNODB;

CREATE TABLE tb_permissao (
 	id bigint not null auto_increment,
	descricao varchar(255) not null, 
	nome varchar(255) not null, 
	PRIMARY KEY (id)
) engine=INNODB;

CREATE TABLE tb_grupo_permissao (
	grupo_id bigint not null, 
	permissao_id bigint not null, 
	PRIMARY KEY (grupo_id, permissao_id)
) engine=INNODB;

CREATE TABLE tb_usuario_grupo (
	usuario_id bigint not null, 
	grupo_id bigint not null, 
	PRIMARY KEY (usuario_id, grupo_id)
) engine=INNODB;

ALTER TABLE tb_grupo_permissao ADD CONSTRAINT FKebkjqmqseopi0eipijfo06vh8 FOREIGN KEY (permissao_id) REFERENCES tb_permissao (id);

ALTER TABLE tb_grupo_permissao ADD CONSTRAINT FKc35tefcxk6t0b4u5qaenlv63e FOREIGN KEY (grupo_id) REFERENCES tb_grupo (id);

ALTER TABLE tb_usuario_grupo ADD CONSTRAINT FKfox4y8jslkfybem54i4jyndnj FOREIGN KEY (grupo_id) REFERENCES tb_grupo (id);


INSERT INTO tb_usuario (id, nome, email, senha, status) VALUES (NULL, 'Rafael', 'rafael@gmail.com', '$2a$12$gFdoe42OpDLI0J.q8aw0/u/8a0rlB5LdPsNLsUiybD2PPKPDpUtku', '1');
INSERT INTO tb_grupo (id, nome) VALUES ('1', 'ADMINISTRADOR');
INSERT INTO tb_permissao (id, descricao, nome) VALUES ('1', 'Cadastrar usuários', 'CAD_USER');
INSERT INTO tb_grupo_permissao (grupo_id, permissao_id) VALUES ('1', '1');
INSERT INTO tb_usuario_grupo (usuario_id, grupo_id) VALUES ('1', '1');
