package br.com.unipix.api.enumaration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusEnum {
	
	INATIVO(0, "Inativo"),
	ATIVO(1, "Ativo");
	
	private Integer id;
	
	private String nome;
}
