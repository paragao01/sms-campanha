package br.com.unipix.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipix.api.controller.swagger.BlackListControllerSwagger;
import br.com.unipix.api.filter.BlackListFilter;
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
	
}
