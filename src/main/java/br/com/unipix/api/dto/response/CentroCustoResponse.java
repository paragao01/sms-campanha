package br.com.unipix.api.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CentroCustoResponse {

	@JsonProperty(value = "id")
	private Long id;
	
	@JsonProperty(value = "nome")
	private String name;
	
	@JsonProperty(value = "codigo")
	private Integer codigo;
	
	@JsonProperty(value = "status")
	private Boolean status;
	
	@JsonProperty(value = "solucao")
	private Boolean solution;
	
	@JsonProperty(value = "dataCadastro")
	private Date registrationDate;
	
	@JsonProperty(value = "dataAlteracao")
	private Date changeDate;
}
