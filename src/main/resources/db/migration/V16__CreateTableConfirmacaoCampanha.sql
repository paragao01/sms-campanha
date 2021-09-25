create table tb_campanha_confirmacao (
    id INTEGER PRIMARY KEY NOT NULL  AUTO_INCREMENT,
    numero varchar(11) NULL,
    codigo_envio varchar(100) NULL,
    mensagem varchar(100) NULL,
    status INTEGER NULL,
    data_criacao TIMESTAMP NULL,
    campanha_id INTEGER NULL
)engine=InnoDB;