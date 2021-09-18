package br.com.unipix.api.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum StatusEnum {
	ATIVO(1),
	INATIVO(0);
	
	int valor;

	StatusEnum(int valor) {
		this.valor = valor;
	}
}
