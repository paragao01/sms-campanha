package br.com.unipix.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TemplateMensagemRequest {

	@JsonProperty(value = "nome")
	private String name;
	
	@JsonProperty(value = "codigo")
	private Integer code;
	
	@JsonProperty(value = "centroCusto")
	private Long costCenter;
	
	@JsonProperty(value = "modelo")
	private String template;
	
	@JsonProperty(value = "status")
	private Boolean status;
}
