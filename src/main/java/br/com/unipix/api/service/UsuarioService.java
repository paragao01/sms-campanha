package br.com.unipix.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipix.api.model.Usuario;
import br.com.unipix.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	
	public List<Usuario> buscarTodos(){
		return repository.findAll();
	}

}
