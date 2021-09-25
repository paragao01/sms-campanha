package br.com.unipix.api.controller.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.unipix.api.dto.response.CampanhaConfirmacaoResponse;
import br.com.unipix.api.exception.handler.Problem;
import br.com.unipix.api.filter.CampanhaConfirmacaoSearchFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller da Etapa de Confirmação da Campanha")
public interface CampanhaConfirmacaoControllerSwagger {

	
	@ApiOperation(value = "Buscar por filtros", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = CampanhaConfirmacaoResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<List<CampanhaConfirmacaoResponse>> getByFilter(CampanhaConfirmacaoSearchFilter filter);
	
	@ApiOperation(value = "Excluir um Número", httpMethod = "DELETE")
	@ApiResponses({ @ApiResponse(code = 200, response = CampanhaConfirmacaoResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<CampanhaConfirmacaoResponse> delete(Long id);
	
}
