package br.com.unipix.api.service.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unipix.api.dto.request.CentroCustoRequest;
import br.com.unipix.api.dto.response.CentroCustoResponse;
import br.com.unipix.api.exception.EntidadeNaoEncontradaException;
import br.com.unipix.api.mapper.CentroCustoMapper;
import br.com.unipix.api.model.CentroCusto;
import br.com.unipix.api.repository.CentroCustoRepository;
import br.com.unipix.api.service.CentroCustoService;

@Service
public class CentroCustoServiceImpl implements CentroCustoService {
	
	@Autowired
	private CentroCustoMapper mapper;
	
	@Autowired
	private CentroCustoRepository repository;
	
	@Override
	@Transactional
	public CentroCustoResponse create (CentroCustoRequest request) {
		
		CentroCusto model = CentroCusto.builder()
				.changeDate(Date.from(Instant.now()))
				.registrationDate(Date.from(Instant.now()))
				.codigo(request.getCodigo())
				.name(request.getName())
				.solution(true)
				.status(true)
				.build();
			
		CentroCusto savedModel = repository.save(model);
		
		return mapper.modelToResponse(savedModel);
	}
	
	@Override
	@Transactional
	public CentroCustoResponse update (CentroCustoRequest request, Long id) {
		
		CentroCusto modelDB = repository.findById(id).orElseThrow(() -> new 
				EntidadeNaoEncontradaException("Centro de Custo de ID: " + id + " não encontrado") {});
	
		CentroCusto model = mapper.requestToModel(request);
		
		BeanUtils.copyProperties(modelDB, model, "status", "solution", "nome", "codigo");
		model.setChangeDate(Date.from(Instant.now()));
		
		repository.save(model);
		
		return mapper.modelToResponse(model);
		
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		
		CentroCusto modelDB = repository.findById(id).orElseThrow(() -> new 
				EntidadeNaoEncontradaException("Centro de Custo de ID: " + id + " não encontrado") {});
	
		repository.delete(modelDB);
	}
	
	@Override
	public CentroCustoResponse findById(Long id) { 
		
		CentroCusto modelDB = repository.findById(id).orElseThrow(() -> new 
				EntidadeNaoEncontradaException("Centro de Custo de ID: " + id + " não encontrado") {});
	
		return mapper.modelToResponse(modelDB);
	}
	
	@Override
	public List<CentroCustoResponse> findByParameter(String parameter) { 
		
		List<CentroCusto> model = repository.findByPameter(parameter.toLowerCase());
	
		return model.stream().map(m -> mapper.modelToResponse(m)).collect(Collectors.toList());
	}
	
	@Override
	public List<CentroCustoResponse> list() {
		
		List<CentroCusto> model = repository.findAll();
		
		return model.stream().map(m -> mapper.modelToResponse(m)).collect(Collectors.toList());
	}

}
