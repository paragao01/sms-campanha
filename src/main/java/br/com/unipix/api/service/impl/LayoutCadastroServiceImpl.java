package br.com.unipix.api.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.unipix.api.dto.request.LayoutCadastroRequest;
import br.com.unipix.api.dto.response.LayoutCadastroResponse;
import br.com.unipix.api.exception.BusinessException;
import br.com.unipix.api.exception.EntidadeNaoEncontradaException;
import br.com.unipix.api.mapper.LayoutCadastroMapper;
import br.com.unipix.api.model.LayoutCadastro;
import br.com.unipix.api.repository.CentroCustoRepository;
import br.com.unipix.api.repository.LayoutCadastroRepository;
import br.com.unipix.api.service.LayoutCadastroService;

@Service
public class LayoutCadastroServiceImpl implements LayoutCadastroService{
	
	@Autowired
	private LayoutCadastroRepository repository;
	
	@Autowired
	private LayoutCadastroMapper mapper;

	@Autowired
	private CentroCustoRepository centroCustoRepository;
	
	@Override
	public Page<LayoutCadastroResponse> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(l -> mapper.modelToResponse(l));
	}

	@Override
	public List<LayoutCadastroResponse> findAll() {
		return repository.findAll().stream().map(l -> mapper.modelToResponse(l)).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("serial")
	public LayoutCadastroResponse findById(Long id) {
		LayoutCadastro model = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Layout de cadastro de código: %d não encontrado.", id)) {});
		return mapper.modelToResponse(model);
	}

	
	@Override
	@SuppressWarnings("serial")
	public LayoutCadastroResponse create(LayoutCadastroRequest request) {
		LayoutCadastro model = mapper.requestToModel(request);
		if(Objects.nonNull(request.getCentroCusto()) && Objects.nonNull(request.getCentroCusto().getId())) {
			centroCustoRepository.findById(request.getCentroCusto().getId()).orElseThrow(() -> new BusinessException(String.format("Centro de custo de código: %d não encontrado.", request.getCentroCusto().getId())) {});
		}
		LayoutCadastro savedModel = repository.save(model);
		return mapper.modelToResponse(savedModel) ;
	}

	@Override
	@SuppressWarnings("serial")
	public LayoutCadastroResponse update(Long id, LayoutCadastroRequest request) {
		LayoutCadastro model = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Layout de cadastro de código: %d não encontrado.", id)) {});
		LayoutCadastro savedModel = repository.save(mapper.requestToModel(request));
		return mapper.modelToResponse(savedModel);
	}

	@Override
	@SuppressWarnings("serial")
	public void delete(Long id) {
		LayoutCadastro model = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Layout de cadastro de código: %d não encontrado.", id)) {});
		repository.delete(model);
		
	}
	

}
