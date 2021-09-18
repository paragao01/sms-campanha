package br.com.unipix.api.service.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unipix.api.dto.request.TemplateMensagemRequest;
import br.com.unipix.api.dto.response.TemplateMensagemResponse;
import br.com.unipix.api.exception.EntidadeNaoEncontradaException;
import br.com.unipix.api.mapper.TemplateMensagemMapper;
import br.com.unipix.api.model.CentroCusto;
import br.com.unipix.api.model.TemplateMensagem;
import br.com.unipix.api.repository.TemplateMensagemRepository;
import br.com.unipix.api.service.TemplateMensagemService;

@Service
public class TemplateMensagemServiceImpl implements TemplateMensagemService{

	@Autowired
	private TemplateMensagemMapper mapper;
	
	@Autowired
	private TemplateMensagemRepository repository;

	@Override
	@Transactional
	public TemplateMensagemResponse create(TemplateMensagemRequest request) {
		
		TemplateMensagem model = TemplateMensagem.builder()
				.changeDate(Date.from(Instant.now()))
				.code(request.getCode())
				.costCenter(CentroCusto.builder().id(request.getCostCenter()).build())
				.name(request.getName())
				.status(true)
				.template(request.getTemplate())
				.characters(request.getTemplate().length())
				.build();
		
		TemplateMensagem savedModel = repository.save(model);
		
		return mapper.modelToResponse(savedModel);			
	}

	@Override
	public TemplateMensagemResponse update(TemplateMensagemRequest request, Long id) {
		
		TemplateMensagem modelDB = repository.findById(id).orElseThrow(() -> new
				EntidadeNaoEncontradaException("Template de ID: " + id + " não encontrado.") {});
		
		TemplateMensagem model = mapper.requestToModel(request);
		
		BeanUtils.copyProperties(model, modelDB, "id");
		modelDB.setChangeDate(Date.from(Instant.now()));
		modelDB.setCharacters(request.getTemplate().length());
		modelDB.setCostCenter(CentroCusto.builder().id(request.getCostCenter()).build());
		
		repository.save(modelDB);
		
		return mapper.modelToResponse(modelDB);
	}

	@Override
	public List<TemplateMensagemResponse> list() {
		
		List<TemplateMensagem> model = repository.findAll();
		
		return model.stream().map(m -> mapper.modelToResponse(m)).collect(Collectors.toList());
	}

	@Override
	public TemplateMensagemResponse findById(Long id) {
		
		TemplateMensagem modelDB = repository.findById(id).orElseThrow(() -> new
				EntidadeNaoEncontradaException("Template de ID: " + id + " não encontrado.") {});
		
		return mapper.modelToResponse(modelDB);
	}

	@Override
	public void delete(Long id) {
		
		TemplateMensagem modelDB = repository.findById(id).orElseThrow(() -> new
				EntidadeNaoEncontradaException("Template de ID: " + id + " não encontrado.") {});
		
		repository.delete(modelDB);
	}

	@Override
	public List<TemplateMensagemResponse> findByParameter(String parameter) {
		
		List<TemplateMensagem> model = repository.findByParameter(parameter.toLowerCase());
		
		return model.stream().map(m -> mapper.modelToResponse(m)).collect(Collectors.toList());
	}
	
}
