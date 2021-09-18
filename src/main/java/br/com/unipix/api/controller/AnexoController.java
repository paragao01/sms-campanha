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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.unipix.api.controller.swagger.AnexoControllerSwagger;
import br.com.unipix.api.model.Anexo;
import br.com.unipix.api.service.impl.AnexoServiceImpl;

@RestController
@RequestMapping("/anexo")
public class AnexoController implements AnexoControllerSwagger{
		
	@Autowired
	private AnexoServiceImpl service;
	
	@GetMapping
	@Override
	public ResponseEntity<Page<Anexo>> findAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	@Override
	public ResponseEntity<Anexo> getById(Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	@Override
	public ResponseEntity<Anexo> create(MultipartFile file, UriComponentsBuilder uri) {
		Anexo model = service.create(file);
		return ResponseEntity.created(uri.path("/anexo/{id}").buildAndExpand(model.getId()).toUri()).body(model);
	}
	
	@PutMapping("/{id}")
	@Override
	public ResponseEntity<Anexo> update(MultipartFile file, @PathVariable Long  id) {
	 	
		return ResponseEntity.ok(service.update(id, file));
	}
	
	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Anexo> delete(@PathVariable Long  id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
