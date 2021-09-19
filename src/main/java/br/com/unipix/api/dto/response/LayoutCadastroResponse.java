package br.com.unipix.api.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.unipix.api.enumaration.StatusEnum;
import br.com.unipix.api.model.Anexo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LayoutCadastroResponse {
	
	private Long id;
	@JsonProperty(value = "nome")
	private String name;

	@JsonProperty(value = "codigo")
	private Long code;

	private CentroCustoResponse centroCusto;

	@JsonProperty(value = "numeroCampos")
	private Long numberFields;

	@JsonProperty(value = "quantidadeTelefone")
	private Long amountTelephone;

	@JsonProperty("ignorarCabecalho")
	private StatusEnum ignoreHeader;
	
	@JsonProperty(value = "status")
	private StatusEnum status;

	@JsonProperty("dataCriacao")
	private Date createDate;
	
	private Anexo anexo;
}
