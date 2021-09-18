package br.com.unipix.api.controller.swagger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.unipix.api.dto.request.LayoutCadastroRequest;
import br.com.unipix.api.dto.response.LayoutCadastroResponse;
import br.com.unipix.api.exception.handler.Problem;
import br.com.unipix.api.model.Anexo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(tags  ="Controller de Layout de Cadastro ")
public interface LayoutCadastroControllerSwagger {
	
	@ApiOperation(value = "Retorna um paginavel de Layout de cadastro", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = Anexo.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	public ResponseEntity<Page<LayoutCadastroResponse>> findAll(Pageable pageable);
	
	@ApiOperation(value = "Busca um Layout de cadastro pelo id", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = Anexo.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	public ResponseEntity<LayoutCadastroResponse> getById(Long id);

	@ApiOperation(value = "Cria um Layout de cadastro", httpMethod = "POST")
	@ApiResponses({ @ApiResponse(code = 200, response = Anexo.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	public ResponseEntity<LayoutCadastroResponse> create(LayoutCadastroRequest request, UriComponentsBuilder uri);

	@ApiOperation(value = "Atualizar um Layout de cadastro", httpMethod = "PUT")
	@ApiResponses({ @ApiResponse(code = 200, response = Anexo.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	public ResponseEntity<LayoutCadastroResponse> update( LayoutCadastroRequest request, Long  id);
	
	@ApiOperation(value = "Deletar um Layout de cadastro", httpMethod = "DELETE")
	@ApiResponses({ @ApiResponse(code = 200, response = Anexo.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	public ResponseEntity<LayoutCadastroResponse> delete(Long  id);
}
