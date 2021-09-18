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

import br.com.unipix.api.controller.swagger.TemplateMensagemControllerSwagger;
import br.com.unipix.api.dto.request.TemplateMensagemRequest;
import br.com.unipix.api.dto.response.TemplateMensagemResponse;
import br.com.unipix.api.service.TemplateMensagemService;

@RestController
@RequestMapping("/template-mensagem")
public class TemplateMensagemController implements TemplateMensagemControllerSwagger {

	@Autowired
	private TemplateMensagemService service;
	
	@Override
	@GetMapping
	public ResponseEntity<List<TemplateMensagemResponse>> getTemplates() {
		
		List<TemplateMensagemResponse> templates = service.list();
		
		return templates.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(templates);
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<TemplateMensagemResponse> getById(@PathVariable Long id) {
		
		TemplateMensagemResponse template = service.findById(id);
		
		return ResponseEntity.ok(template);
	}
	
	@Override
	@GetMapping("/nome-ou-codigo/{parametro}")
	public ResponseEntity<List<TemplateMensagemResponse>> getByParameter(@PathVariable String parametro) {
		
		List<TemplateMensagemResponse> templates = service.findByParameter(parametro);
		
		return templates.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(templates);
	}
	
	@Override
	@PostMapping
	public ResponseEntity<TemplateMensagemResponse> create(@RequestBody @Valid TemplateMensagemRequest request,
			UriComponentsBuilder uri) {
		
		TemplateMensagemResponse template = service.create(request);
		
		return ResponseEntity.created(uri.path("/template-mensagem/{id}").buildAndExpand(template.getId()).toUri()).body(template);
	}
	
	@Override
	@PutMapping("/{id}")
	public ResponseEntity<TemplateMensagemResponse> update(@RequestBody @Valid TemplateMensagemRequest request,
			@PathVariable Long id) {
		
		TemplateMensagemResponse template = service.update(request, id);
		
		return ResponseEntity.ok(template);
	}
	
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<TemplateMensagemResponse> delete(@PathVariable Long id) {
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
