package br.com.unipix.api.controller.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.unipix.api.dto.request.CentroCustoRequest;
import br.com.unipix.api.dto.response.CentroCustoResponse;
import br.com.unipix.api.exception.handler.Problem;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface CentroCustoControllerSwagger {

	@ApiOperation(value = "Busca todos os Centros de Custo", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = CentroCustoResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<List<CentroCustoResponse>> getCenterList();

	@ApiOperation(value = "Criar Centro de Custo", httpMethod = "POST")
	@ApiResponses({ @ApiResponse(code = 200, response = CentroCustoResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<CentroCustoResponse> createCenter(CentroCustoRequest request, UriComponentsBuilder uri);

	@ApiOperation(value = "Busca um Centro de Custo", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = CentroCustoResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<CentroCustoResponse> getById(Long id);

	@ApiOperation(value = "Deletar um Centro de Custo", httpMethod = "DELETE")
	@ApiResponses({ @ApiResponse(code = 200, response = CentroCustoResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<CentroCustoResponse> delete(Long id);

	@ApiOperation(value = "Atualizar um Centro de Custo", httpMethod = "UPDATE")
	@ApiResponses({ @ApiResponse(code = 200, response = CentroCustoResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<CentroCustoResponse> updateCenter(CentroCustoRequest request, Long id);

	@ApiOperation(value = "Busca um Centro de Custo por código ou nome", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = CentroCustoResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<List<CentroCustoResponse>> getByParameter(@PathVariable String parametro);
}
