package br.com.unipix.api.controller.swagger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import br.com.unipix.api.dto.response.UserResponse;
import br.com.unipix.api.exception.handler.Problem;
import br.com.unipix.api.filter.BlackListFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de BlackList")
public interface BlackListControllerSwagger {

		@ApiOperation(value = "Busca todos os usuários", httpMethod = "GET")
		@ApiResponses({
			@ApiResponse(code = 200, response = UserResponse.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
		})
		ResponseEntity<Page<?>>findAll(@PageableDefault(size = 10) Pageable page, BlackListFilter filter);
}
