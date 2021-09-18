package br.com.unipix.api.controller.swagger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.unipix.api.exception.handler.Problem;
import br.com.unipix.api.model.Anexo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags  = "Controler de Anexo")
public interface AnexoControllerSwagger {
	
	@ApiOperation(value = "Retorna um paginavel de arquivos", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = Anexo.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<Page<Anexo>> findAll(Pageable pageable);
	
	@ApiOperation(value = "Busca um arquivo pelo id", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 200, response = Anexo.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<Anexo> getById(Long id);

	@ApiOperation(value = "Cria um arquivo", httpMethod = "POST")
	@ApiResponses({ @ApiResponse(code = 200, response = Anexo.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<Anexo> create(MultipartFile file, UriComponentsBuilder uri);
	
	@ApiOperation(value = "Atualizar um arquivo", httpMethod = "PUT")
	@ApiResponses({ @ApiResponse(code = 200, response = Anexo.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<Anexo> update(MultipartFile file, Long id);

	@ApiOperation(value = "Deletar um arquivo", httpMethod = "DELETE")
	@ApiResponses({ @ApiResponse(code = 200, response = Anexo.class, message = "Requisição com sucesso"),
			@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado") })
	ResponseEntity<Anexo> delete(Long id);


}
