package br.com.unipix.api.dto.response;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlackListResponse {

	@JsonProperty("centroCusto")
	private CentroCustoResponse centroCusto;
	
	private Blob anexo;
	
	private List<ManualResponse> manual;
	
	private Date dataCadastro;
}
