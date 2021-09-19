ALTER TABLE tb_layout_cadastro ADD anexo_id BIGINT NULL;
ALTER TABLE tb_layout_cadastro ADD CONSTRAINT tb_layout_cadastro_FK_1 FOREIGN KEY (anexo_id) REFERENCES unipix.tb_anexo(id);
