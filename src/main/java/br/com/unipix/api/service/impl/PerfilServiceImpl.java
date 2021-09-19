package br.com.unipix.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.unipix.api.dto.request.PerfilRequest;
import br.com.unipix.api.dto.response.PerfilResponse;
import br.com.unipix.api.exception.EntidadeNaoEncontradaException;
import br.com.unipix.api.mapper.PerfilMapper;
import br.com.unipix.api.model.Grupo;
import br.com.unipix.api.repository.PerfilRepository;
import br.com.unipix.api.service.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService{
	
	@Autowired
	private PerfilRepository repository;
	
	@Autowired
	private PerfilMapper mapper;
	
	@Override
	public Page<PerfilResponse> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(p -> mapper.modelToResponse(p));
	}

	@Override
	public List<PerfilResponse> findAll() {
		return repository.findAll().stream().map(l -> mapper.modelToResponse(l)).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("serial")
	public PerfilResponse findById(Long id) {
		Grupo model = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Perfil de código: %d não encontrado.", id)) {});
		return mapper.modelToResponse(model);
	}

	
	@Override
	@SuppressWarnings("serial")
	public PerfilResponse create(PerfilRequest request) {
		
		Grupo model = mapper.requestToModel(request);
		Grupo savedModel = repository.save(model);
		
		return mapper.modelToResponse(savedModel) ;
	}

	@Override
	@SuppressWarnings("serial")
	public PerfilResponse update(Long id, PerfilRequest request) {
		
		Grupo model = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Layout de cadastro de código: %d não encontrado.", id)) {});
		BeanUtils.copyProperties(mapper.requestToModel(request), model, "id");
		Grupo savedModel = repository.save(model);
		
		return mapper.modelToResponse(savedModel);
	}

	@Override
	@SuppressWarnings("serial")
	public void delete(Long id) {
		Grupo model = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Perfil de código: %d não encontrado.", id)) {});
		repository.delete(model);
		
	}
}
