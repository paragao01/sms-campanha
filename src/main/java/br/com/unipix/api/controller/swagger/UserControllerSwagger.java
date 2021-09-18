package br.com.unipix.api.controller.swagger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.unipix.api.dto.request.UserRequest;
import br.com.unipix.api.dto.response.UserResponse;
import br.com.unipix.api.exception.handler.Problem;
import br.com.unipix.api.filter.UserFilter;
import br.com.unipix.api.model.User;
import br.com.unipix.api.repository.specification.UserSpecification;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de usuários")
public interface UserControllerSwagger {

	@ApiOperation(value = "Busca todos os usuários", httpMethod = "GET")
	@ApiResponses({
		@ApiResponse(code = 200, response = UserResponse.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<Page<?>>findAll(@PageableDefault(size = 10) Pageable page, UserSpecification spec, UserFilter filter);
	
	@ApiOperation(value = "Busca um único usuário", httpMethod = "GET")
	@ApiResponses({
		@ApiResponse(code = 200, response = UserResponse.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?>findById(Long id);
	
	@ApiOperation(value = "Salva um usuário", httpMethod = "POST")
	@ApiResponses({
		@ApiResponse(code = 200, response = UserResponse.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?> save(@RequestBody UserRequest user, UriComponentsBuilder uri);
	
	@ApiOperation(value = "Atualiza um usuário", httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 200, response = UserResponse.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<UserResponse>update(@RequestBody UserRequest user, Long id);
	
	@ApiOperation(value = "Deleta um usuário", httpMethod = "DELETE")
	@ApiResponses({
		@ApiResponse(code = 200, response = UserResponse.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?>delete(@PathVariable Long id);
	
	@ApiOperation(value = "Ativa um usuário", httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 200, response = UserResponse.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?>activate(@PathVariable Long id);
	
	@ApiOperation(value = "Desativa um usuário", httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 200, response = UserResponse.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?>disable(@PathVariable Long id);
} 
