package br.com.unipix.api.controller.swagger;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.unipix.api.dto.request.TemplateMensagemRequest;
import br.com.unipix.api.dto.response.TemplateMensagemResponse;
import br.com.unipix.api.enumaration.VariavelEnum;
import br.com.unipix.api.exception.handler.Problem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de Templates de Mensagem")
public interface TemplateMensagemControllerSwagger {
	
	@ApiOperation(value = "Busca todos os Templates", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = TemplateMensagemResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<List<TemplateMensagemResponse>> getTemplates();
	
	@ApiOperation(value = "Busca um Template", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = TemplateMensagemResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<TemplateMensagemResponse> getById(Long id);
	
	@ApiOperation(value = "Busca Templates por Código ou Nome", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = TemplateMensagemResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<List<TemplateMensagemResponse>> getByParameter(String parametro);
	
	@ApiOperation(value = "Cria um Template", httpMethod = "POST")
	@ApiResponses({ @ApiResponse(code = 200, response = TemplateMensagemResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<TemplateMensagemResponse> create(TemplateMensagemRequest request,
			UriComponentsBuilder uri);
	
	@ApiOperation(value = "Atualizar um Template", httpMethod = "PUT")
	@ApiResponses({ @ApiResponse(code = 200, response = TemplateMensagemResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<TemplateMensagemResponse> update(TemplateMensagemRequest request,
			Long id);
	
	@ApiOperation(value = "Excluir um Template", httpMethod = "DELETE")
	@ApiResponses({ @ApiResponse(code = 200, response = TemplateMensagemResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<TemplateMensagemResponse> delete(@PathVariable Long id);
	
	@ApiOperation(value = "Busca Variaveis de Template", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = TemplateMensagemResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<HashMap<VariavelEnum, String>> findVariables();

}
