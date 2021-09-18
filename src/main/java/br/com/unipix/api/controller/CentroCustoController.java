package br.com.unipix.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.unipix.api.controller.swagger.CentroCustoControllerSwagger;
import br.com.unipix.api.dto.request.CentroCustoRequest;
import br.com.unipix.api.dto.response.CentroCustoResponse;
import br.com.unipix.api.service.CentroCustoService;

@RestController
@RequestMapping("/centro-de-custo")
public class CentroCustoController implements CentroCustoControllerSwagger {
	
	
	@Autowired
	private CentroCustoService service;
	
	@Override
	@GetMapping
	public ResponseEntity<List<CentroCustoResponse>> getCenterList() {
		
		List<CentroCustoResponse> list = service.list();
		
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}
	
	@Override
	@PostMapping
	public ResponseEntity<CentroCustoResponse> createCenter(@RequestBody @Valid CentroCustoRequest request,
			UriComponentsBuilder uri) {
		
		CentroCustoResponse response = service.create(request);
		
		return ResponseEntity.created(uri.path("/centro-de-custo/{id}").buildAndExpand(response.getId()).toUri()).body(response);
		
	}
	
	@Override
	@PutMapping("/{id}")
	public ResponseEntity<CentroCustoResponse> updateCenter(@RequestBody CentroCustoRequest request,
			@PathVariable Long id) {
		
		CentroCustoResponse response = service.update(request, id);
		
		return ResponseEntity.ok(response);
	}
	
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<CentroCustoResponse> delete(@PathVariable Long id) {
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<CentroCustoResponse> getById(@PathVariable Long id) {
		
		CentroCustoResponse response = service.findById(id);
		
		return ResponseEntity.ok(response);
		
	}
	
	@Override
	@GetMapping("/nome-ou-codigo/{parametro}")
	public ResponseEntity<List<CentroCustoResponse>> getByParameter(@PathVariable String parametro) {
		
		List<CentroCustoResponse> response = service.findByParameter(parametro);
		
		return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
		
	}

}
