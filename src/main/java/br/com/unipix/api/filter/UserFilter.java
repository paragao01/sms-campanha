package br.com.unipix.api.filter;

import br.com.unipix.api.enums.StatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserFilter {
	
	@ApiModelProperty(name = "name", value = "nome", dataType = "String", example = "teste")
	private String name;
	
	@ApiModelProperty(name = "email", value = "email", dataType = "String", example = "teste@gmail.com")
	private String email;
	
	
	
	
}
