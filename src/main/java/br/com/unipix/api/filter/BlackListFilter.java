package br.com.unipix.api.filter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlackListFilter {
	
	@ApiModelProperty(name = "centroCusto", value = "centroCusto", dataType = "Long")
	private Long centroCusto;
}
