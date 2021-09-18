package br.com.unipix.api.enumaration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VariavelEnum {
	
	NOME(0L, "Nome"),
	TELEFONE(1L, "Telefone"),
	CAMPANHA(2L, "Campanha");

	Long id;
	
	String description;
	
	public static VariavelEnum getById(Long id)
	{
		for (VariavelEnum variables : values())
		{
			if(variables.id.equals(id))
			{
				return variables;
			}
		}
		
		return null;
	}
}
