package br.com.unipix.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipix.api.config.security.CheckSecurity;
import br.com.unipix.api.controller.swagger.DadosControllerSwagger;


@RestController
@RequestMapping("/estatistica-sumarizada")
public class DadosSumarizadosController implements DadosControllerSwagger {

	
	@CheckSecurity.DadosSumarizados.PodeAcessar
	@GetMapping("/periodo")
	public void findAllPeriodo() {
		 
	}

	
	
	
}
