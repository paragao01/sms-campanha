package br.com.unipix.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import br.com.unipix.api.controller.swagger.UserControllerSwagger;
import br.com.unipix.api.dto.request.UserRequest;
import br.com.unipix.api.dto.response.UserResponse;
import br.com.unipix.api.filter.UserFilter;
import br.com.unipix.api.repository.specification.UserSpecification;
import br.com.unipix.api.service.UserService;


@RestController
@RequestMapping("/usuario")

public class UserController implements UserControllerSwagger {
	
	@Autowired
	private UserService service;

	@Override
	//@CheckSecurity.DadosSumarizados.PodeAcessar
	@GetMapping()
	public ResponseEntity<Page<?>> findAll(@PageableDefault(size = 10) Pageable page, UserSpecification spec, UserFilter filter) {
		return ResponseEntity.ok(service.findAll(spec, page));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@Override
	@PostMapping
	public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest user, UriComponentsBuilder uri) {
		UserResponse userSaved = service.save(user);
		return ResponseEntity.created(uri.path("/usuario/{id}").buildAndExpand(userSaved).toUri()).body(userSaved);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<UserResponse> update(@RequestBody @Valid UserRequest user, @PathVariable Long id) {
		UserResponse userSaved = service.update(user, id);
		return ResponseEntity.ok(userSaved);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@PutMapping("/ativar/{id}")
	public ResponseEntity<?> activate(@PathVariable Long id) {
		UserResponse user = service.activate(id);
		return ResponseEntity.ok(user);
	}

	@Override
	@PutMapping("/desativar/{id}")
	public ResponseEntity<?> disable(@PathVariable Long id) {
		UserResponse user = service.disable(id);
		return ResponseEntity.ok(user);
	}

}
