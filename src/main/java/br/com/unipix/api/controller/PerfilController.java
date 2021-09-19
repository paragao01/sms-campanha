package br.com.unipix.api.controller;

import javax.validation.Valid;

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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.unipix.api.dto.request.PerfilRequest;
import br.com.unipix.api.dto.response.PerfilResponse;
import br.com.unipix.api.service.impl.PerfilServiceImpl;

public class PerfilController {

	@Autowired
	private PerfilServiceImpl service;
	
	@GetMapping
	public ResponseEntity<Page<PerfilResponse>> findAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PerfilResponse> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<PerfilResponse> create(@Valid @RequestBody PerfilRequest request, UriComponentsBuilder uri) {
		PerfilResponse dto = service.create(request);
		return ResponseEntity.created(uri.path("/perfil/{id}").buildAndExpand(dto.getId()).toUri()).body(dto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PerfilResponse> update(@Valid @RequestBody PerfilRequest request, @PathVariable(required = true) Long  id) {

		return ResponseEntity.ok(service.update(id, request));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PerfilResponse> delete(@PathVariable(required = true) Long  id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
