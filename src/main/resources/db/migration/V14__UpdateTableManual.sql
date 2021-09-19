drop table tb_blacklist;
CREATE TABLE tb_blacklist (
  id bigint NOT NULL AUTO_INCREMENT,
  anexo_id bigint DEFAULT NULL,
  centroCusto_id bigint DEFAULT NULL,
  data_cadastro timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id)
);