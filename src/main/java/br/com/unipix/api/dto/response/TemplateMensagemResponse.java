package br.com.unipix.api.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TemplateMensagemResponse {

	@JsonProperty(value = "id")
	private Long id;
	
	@JsonProperty(value = "nome")
	private String name;
	
	@JsonProperty(value = "codigo")
	private Integer code;
	
	@JsonProperty(value = "centroCusto")
	private CentroCustoResponse costCenter;
	
	@JsonProperty(value = "modelo")
	private String template;
	
	@JsonProperty(value = "status")
	private Boolean status;
	
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "Brazil/East")
	@JsonProperty(value = "dataAlteracao")
	private Date changeDate;
	
	@JsonProperty(value = "caracteres")
	private Integer characters;
}
