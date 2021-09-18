package br.com.unipix.api.dto.request;

import br.com.unipix.api.enumaration.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LayoutCadastroRequest {
		
	private String name;
	
	private Long code;
	
	private Integer CentroCusto;

	private Long numberFields;
	
	private Long quantideTelefones;
	
	private Integer type;
	
	private StatusEnum status;
	
	private StatusEnum ignoreHeader;
	
}
