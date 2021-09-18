package br.com.unipix.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipix.api.config.security.CheckSecurity;
import br.com.unipix.api.controller.swagger.UsuarioControllerSwagger;
import br.com.unipix.api.filter.EstatisticaFilter;
import br.com.unipix.api.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController implements UsuarioControllerSwagger {
	
	@Autowired
	private UsuarioService service;

	@Override
	//@CheckSecurity.DadosSumarizados.PodeAcessar
	@GetMapping()
	public ResponseEntity<?> findAllUsuario() {
	 	
		return ResponseEntity.ok(service.buscarTodos());
	}

	
	
	
}
