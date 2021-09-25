package br.com.unipix.api.filter;

import java.util.Date;

import br.com.unipix.api.enumaration.StatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CampanhaConfirmacaoSearchFilter {
	
	
	@ApiModelProperty(value = "ID da Campanha", dataType = "Long")
	private Long campaign;
	
	@ApiModelProperty(value = "Status do Número", dataType = "Enum")
	private StatusEnum status;
	
	@ApiModelProperty(value = "Data de Criação", dataType = "Date")
	private Date date;

}
