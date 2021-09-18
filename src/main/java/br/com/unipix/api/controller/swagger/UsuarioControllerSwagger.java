package br.com.unipix.api.controller.swagger;

import org.springframework.http.ResponseEntity;

import br.com.unipix.api.exception.handler.Problem;
import br.com.unipix.api.filter.EstatisticaFilter;
import br.com.unipix.api.model.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller da Estatistica")
public interface UsuarioControllerSwagger {

	@ApiOperation(value = "Busca todos os usuários", httpMethod = "GET")
	@ApiResponses({
		@ApiResponse(code = 200, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?>findAllUsuario();
} 
