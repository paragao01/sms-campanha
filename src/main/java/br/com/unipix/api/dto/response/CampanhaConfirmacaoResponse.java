package br.com.unipix.api.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.unipix.api.enumaration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampanhaConfirmacaoResponse {
	
	private Long id;
	
	@JsonProperty(value = "numero")
	private String number;
	
	@JsonProperty(value = "codigoEnvio")
	private Integer shippingCode;
	
	@JsonProperty(value = "mensagem")
	private String message;
	
	@JsonProperty(value = "status")
	private StatusEnum status;
	
	@JsonProperty(value = "dataCriacao")
	@JsonFormat(pattern = "dd/MM/yyyy-HH-mm", timezone = "Brazil/East")
	private Date createdDate;

}
