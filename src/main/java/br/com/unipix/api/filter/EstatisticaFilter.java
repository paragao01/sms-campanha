package br.com.unipix.api.filter;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstatisticaFilter {

	@ApiModelProperty(name = "dataInicial", value = "Data Início", required = false, position = 3, dataType = "DateTime", example = "2021-01-31T00:00")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date dataInicial;
	
	
	@ApiModelProperty(name = "dataFinal", value = "Data Final", required = false, position = 3, dataType = "DateTime", example = "2021-01-31T23:59")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date dataFinal;
	
		
	@ApiModelProperty(name = "unidadeAtendimento", value = "Unidade de Atendimento", dataType = "String")
	private List<String> unidadeAtendimento;
	
}
