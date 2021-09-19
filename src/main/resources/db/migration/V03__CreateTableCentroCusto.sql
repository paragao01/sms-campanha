CREATE TABLE tb_centro_de_custo (
    id INTEGER primary key auto_increment NOT NULL,
    nome varchar(100) NOT NULL,
    codigo INTEGER NOT NULL,
    status BOOL NULL,
    solucao BOOL NULL,
    data_cadastro TIMESTAMP NULL,
    data_alteracao TIMESTAMP NULL
)engine=INNODB;