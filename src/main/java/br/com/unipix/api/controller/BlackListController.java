package br.com.unipix.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.unipix.api.controller.swagger.BlackListControllerSwagger;
import br.com.unipix.api.dto.request.BlackListRequest;
import br.com.unipix.api.dto.response.BlackListResponse;
import br.com.unipix.api.filter.BlackListFilter;
import br.com.unipix.api.model.Anexo;
import br.com.unipix.api.model.BlackList;
import br.com.unipix.api.service.BlackListService;

@RestController
@RequestMapping("/blacklist")
public class BlackListController implements BlackListControllerSwagger{

	@Autowired
	private BlackListService service;

	@Override
	@GetMapping
	public ResponseEntity<Page<?>> findAll(Pageable page, BlackListFilter filter) {
		
		return ResponseEntity.ok(service.findAll(page, filter));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		
		return ResponseEntity.ok(service.findById(id));
	}

	@Override
	@PostMapping
	public ResponseEntity<?> save(@RequestBody BlackListRequest blacklist, UriComponentsBuilder uri) {
		
		BlackListResponse blacklistSaved = service.save(blacklist);
		return ResponseEntity.created(uri.path("blacklist/{id}").buildAndExpand(blacklist).toUri()).body(blacklistSaved);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
