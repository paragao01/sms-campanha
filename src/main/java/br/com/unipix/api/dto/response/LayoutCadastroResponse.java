package br.com.unipix.api.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.unipix.api.enumaration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayoutCadastroResponse {
	
	
	private Long id;
	
	@JsonProperty("nome")
	private String name;

	@JsonProperty("codigo")
	private Long code;

	private CentroCustoResponse centroCusto;

	@JsonProperty("numeroCampos")
	private Long numberFields;

	@JsonProperty("quantideTelefones")
	private Long amountTelephone;

	@JsonProperty("tipo")
	private Integer type;

	private StatusEnum status;
	
	@JsonProperty("ignorarCabecalho")
	private StatusEnum ignoreHeader;

	@JsonProperty("dataCriacao")
	private Date createDate;
}
