package br.com.unipix.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.unipix.api.dto.request.LayoutCadastroRequest;
import br.com.unipix.api.dto.response.LayoutCadastroResponse;
import br.com.unipix.api.exception.BusinessException;
import br.com.unipix.api.mapper.LayoutCadastroMapper;
import br.com.unipix.api.model.LayoutCadastro;
import br.com.unipix.api.repository.LayoutCadastroRepository;
import br.com.unipix.api.service.LayoutCadastroService;

@Service
public class LayoutCadastroServiceImpl implements LayoutCadastroService{
	
	@Autowired
	private LayoutCadastroRepository repository;
	
	@Autowired
	private LayoutCadastroMapper mapper;
	
	@Override
	public Page<LayoutCadastroResponse> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(l -> mapper.modelToResponse(l));
	}

	@Override
	public List<LayoutCadastroResponse> findAll() {
		return repository.findAll().stream().map(l -> mapper.modelToResponse(l)).collect(Collectors.toList());
	}

	@Override
	public LayoutCadastroResponse findById(Long id) {
		LayoutCadastro model = repository.findById(id).orElseThrow(() -> new BusinessException(String.format("Layout de cadastro de código: %d não encontrado.", id)));
		return mapper.modelToResponse(model);
	}

	@Override
	public LayoutCadastroResponse create(LayoutCadastroRequest request) {
		LayoutCadastro model = mapper.requestToModel(request);
		LayoutCadastro savedModel = repository.save(model);
		return mapper.modelToResponse(savedModel) ;
	}

	@Override
	public LayoutCadastroResponse update(Long id, LayoutCadastroRequest request) {
		LayoutCadastro model = repository.findById(id).orElseThrow(() -> new BusinessException(String.format("Layout de cadastro de código: %d não encontrado.", id)));
		LayoutCadastro savedModel = repository.save(mapper.requestToModel(request));
		return mapper.modelToResponse(savedModel);
	}

	@Override
	public void delete(Long id) {
		LayoutCadastro model = repository.findById(id).orElseThrow(() -> new BusinessException(String.format("Layout de cadastro de código: %d não encontrado.", id)));
		repository.delete(model);
		
	}
	

}
