package br.com.unipix.api.dto.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import br.com.unipix.api.enumaration.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LayoutCadastroRequest {
	
	@NotNull
	@NotBlank
	@JsonProperty(value = "nome")
	private String name;
	
	@NotNull
	@JsonProperty(value = "codigo")
	private Long code;
	
	private CentroCustoIdRequest centroCusto;

	@JsonProperty(value = "numeroCampos")
	private Long numberFields;
	
	@JsonProperty(value = "quantidadeTelefone")
	private Long amountTelephone;
	
	@JsonProperty(value = "tipo")
	private Integer type;
	
	@JsonProperty(value = "status")
	private StatusEnum status;
	
	@JsonProperty(value = "ignoraCabecalho")
	private StatusEnum ignoreHeader;
	
}
