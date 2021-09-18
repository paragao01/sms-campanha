package br.com.unipix.api.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CentroCustoResponse {

	@JsonProperty(value = "id")
	private Long id;
	
	@JsonProperty(value = "nome")
	private String name;
	
	@JsonProperty(value = "codigo")
	private Integer code;
	
	@JsonProperty(value = "status")
	private Boolean status;
	
	@JsonProperty(value = "solucao")
	private Boolean solution;
	
	@JsonProperty(value = "dataCadastro")
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "Brazil/East")
	private Date registrationDate;
	
	@JsonProperty(value = "dataAlteracao")
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "Brazil/East")
	private Date changeDate;
}
