package br.com.unipix.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.unipix.api.dto.request.LayoutCadastroRequest;
import br.com.unipix.api.dto.response.LayoutCadastroResponse;
import br.com.unipix.api.service.LayoutCadastroService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/layout_cadastro")
@Api(tags  ="Layout de Cadastro Controller")
public class LayoutCadastroController {
	
	@Autowired
	private LayoutCadastroService service;
	
	@GetMapping
	public ResponseEntity<Page<LayoutCadastroResponse>> findAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<LayoutCadastroResponse> getById(Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<LayoutCadastroResponse> create(@RequestBody LayoutCadastroRequest request, UriComponentsBuilder uri) {
		LayoutCadastroResponse dto = service.create(request);
		return ResponseEntity.created(uri.path("/layout_cadastro/{id}").buildAndExpand(dto.getId()).toUri()).body(dto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LayoutCadastroResponse> update(@RequestBody LayoutCadastroRequest request, @PathVariable(required = true) Long  id) {
		return ResponseEntity.ok(service.update(id, request));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<LayoutCadastroResponse> delete(@PathVariable(required = true) Long  id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
