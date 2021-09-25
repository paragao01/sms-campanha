package br.com.unipix.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipix.api.controller.swagger.CampanhaConfirmacaoControllerSwagger;
import br.com.unipix.api.dto.response.CampanhaConfirmacaoResponse;
import br.com.unipix.api.filter.CampanhaConfirmacaoSearchFilter;
import br.com.unipix.api.service.CampanhaConfirmacaoService;

@RestController
@RequestMapping("/campanha-confirmacao")
public class CampanhaConfirmacaoController implements CampanhaConfirmacaoControllerSwagger {
	
	@Autowired
	private CampanhaConfirmacaoService service;
	
	@Override
	@GetMapping
	public ResponseEntity<List<CampanhaConfirmacaoResponse>> getByFilter(CampanhaConfirmacaoSearchFilter filter) {
		
		List<CampanhaConfirmacaoResponse> response = service.list(filter);
		
		return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
	}
	
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<CampanhaConfirmacaoResponse> delete(@PathVariable Long id) {
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
