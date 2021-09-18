package br.com.unipix.api.enumaration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusEnum {
	
	INATIVO(0, "Inativo"),
	ATIVO(1, "Ativo");
	
	private Integer id;

	private String name;
	
	public static StatusEnum getById(Long id) {
	    for(StatusEnum e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    throw new IllegalArgumentException(String.format("Não existe uma constante para o valor %d no ENUM %s",  id,StatusEnum.class.getName()));
	}
}
