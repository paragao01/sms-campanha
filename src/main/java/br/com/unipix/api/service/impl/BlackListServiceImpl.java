package br.com.unipix.api.service.impl;



import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.unipix.api.dto.request.BlackListRequest;
import br.com.unipix.api.dto.response.BlackListResponse;
import br.com.unipix.api.exception.EntidadeNaoEncontradaException;
import br.com.unipix.api.filter.BlackListFilter;
import br.com.unipix.api.mapper.BlackListMapper;
import br.com.unipix.api.model.Anexo;
import br.com.unipix.api.model.BlackList;
import br.com.unipix.api.model.CentroCusto;
import br.com.unipix.api.model.Manual;
import br.com.unipix.api.repository.AnexoRepository;
import br.com.unipix.api.repository.BlackListRepository;
import br.com.unipix.api.repository.ManualRepository;
import br.com.unipix.api.service.BlackListService;
import br.com.unipix.api.service.CentroCustoService;

@Service
public class BlackListServiceImpl implements BlackListService{

	@Autowired
	private BlackListRepository repository;
	
	@Autowired
	private ManualRepository manualRepository;
	
	@Autowired
	private AnexoRepository anexoRepository;
	
	@Autowired
	private CentroCustoService centroService;
	
	@Autowired
	private BlackListMapper mapper;
	
	
	public BlackList searchOrFail(Long id) {
		return repository.findById(id).orElseThrow(() ->
			new EntidadeNaoEncontradaException(String.format("BlackList com o Id %d, não encontrado", id)) {});
	}
	
	@Override
	public Page<BlackListResponse> findAll(Pageable pageable, BlackListFilter filter) {
		Page<BlackList> blackList = repository.findAll(filter, pageable);
		return blackList.map(b -> mapper.modelToResponse(b));
	}
	
	@Override
	public BlackListResponse findById(Long id) {
		BlackList blackList = searchOrFail(id);
		return mapper.modelToResponse(blackList);
	}

	@Override
	public BlackListResponse save(BlackListRequest blackListRequest) {
		centroService.findById(blackListRequest.getCentroCusto());
		CentroCusto centroCusto = CentroCusto.builder()
				.id(blackListRequest.getCentroCusto()).build();
		
		Anexo anexo = anexoRepository.findById(blackListRequest.getAnexo().getId()).orElseThrow(()->
		new EntidadeNaoEncontradaException(String.format("Anexo com id %d, não encontrado",blackListRequest.getAnexo().getId())) {
			private static final long serialVersionUID = 1L;});
		
		String numbers = blackListRequest.getManual();
		List<String> array = Arrays.asList(numbers.split(" "));
		
		BlackList blackList = BlackList.builder()
				.anexo(anexo)
				.centroCusto(centroCusto)
				.dateCreated(Date.from(Instant.now()))
				.build();
		BlackList blackListSaved = repository.save(blackList);
		
		List<Manual> manual = array.stream().map(m -> Manual.builder()
				.blackList_id(blackListSaved)
				.manual(m)
				.build()).collect(Collectors.toList());
		manualRepository.saveAll(manual);
		
		
		return mapper.modelToResponse(searchOrFail(blackListSaved.getId()));
	}

	@Override
	public void delete(Long id) {
		BlackList blackList = searchOrFail(id);
		repository.deleteById(id);				
	}
	
	
	
	
	

}
