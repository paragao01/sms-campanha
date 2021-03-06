package br.com.unipix.api.controller;

import java.util.HashMap;
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

import br.com.unipix.api.config.security.CheckSecurity;
import br.com.unipix.api.config.security.UnipixSecurity;
import br.com.unipix.api.controller.swagger.TemplateMensagemControllerSwagger;
import br.com.unipix.api.dto.request.TemplateMensagemRequest;
import br.com.unipix.api.dto.response.TemplateMensagemResponse;
import br.com.unipix.api.enumaration.VariavelEnum;
import br.com.unipix.api.service.TemplateMensagemService;

@RestController
@RequestMapping("/template-mensagem")
public class TemplateMensagemController implements TemplateMensagemControllerSwagger {

	@Autowired
	private TemplateMensagemService service;
	
	@Autowired
	private UnipixSecurity security;
	
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
	@CheckSecurity.TemplateMensagem.PodeAcessar
	@PostMapping
	public ResponseEntity<TemplateMensagemResponse> create(@RequestBody @Valid TemplateMensagemRequest request,
			UriComponentsBuilder uri) {
		
		request.setUser(security.getUsuarioId());
		
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
	
	@Override
	@GetMapping("/variaveis")
	public ResponseEntity<HashMap<VariavelEnum, String>> findVariables() {
		
		HashMap<VariavelEnum, String> variables = service.listVariables();
		
		return variables.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(variables);
	}
	
}
