create table tb_template_mensagem (
    id INTEGER not null primary key auto_increment,
    nome VARCHAR(30) not null,
    codigo INTEGER not null,
    centro_custo_id INTEGER not null,
    modelo VARCHAR(1160) not null,
    status BOOL null,
    data_alteracao TIMESTAMP null,
    caracteres INTEGER null
)engine=INNODB;