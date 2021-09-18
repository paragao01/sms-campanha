package br.com.unipix.api.dto.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class CentroCustoRequest {

	@NotNull
	@NotBlank
	@JsonProperty(value = "nome")
	private String name;
	
	@NotNull
	@JsonProperty(value = "codigo")
	private Integer codigo;
	
	@JsonProperty(value = "status")
	private Boolean status;
	
	@JsonProperty(value = "solucao")
	private Boolean solution;
}
