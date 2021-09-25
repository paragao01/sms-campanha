package br.com.unipix.api.service.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipix.api.dto.response.CampanhaConfirmacaoResponse;
import br.com.unipix.api.dto.response.NumeroCampanhaValidado;
import br.com.unipix.api.enumaration.StatusEnum;
import br.com.unipix.api.exception.EntidadeNaoEncontradaException;
import br.com.unipix.api.filter.CampanhaConfirmacaoSearchFilter;
import br.com.unipix.api.mapper.CampanhaConfirmacaoMapper;
import br.com.unipix.api.model.CampanhaConfirmacao;
import br.com.unipix.api.repository.CampanhaConfirmacaoRepository;
import br.com.unipix.api.service.CampanhaConfirmacaoService;

@Service
public class CampanhaConfirmacaoServiceImpl implements CampanhaConfirmacaoService {

	@Autowired
	private CampanhaConfirmacaoMapper mapper;
	
	@Autowired
	private CampanhaConfirmacaoRepository repository;
	
	@Override
	public List<CampanhaConfirmacaoResponse> build(NumeroCampanhaValidado numeros) {
		
		List<CampanhaConfirmacao> response = new ArrayList<CampanhaConfirmacao>();
		
		if(numeros != null) {
			
			numeros.getInvalidatedNumbers().forEach(invalidNumber -> {
					CampanhaConfirmacao confirmInvalidNumber = CampanhaConfirmacao.builder()
					.createdDate(Date.from(Instant.now()))
					.shippingCode(getRandomNumber(1000, 9999))
					.number(invalidNumber)
					.status(StatusEnum.INVALIDO)
					.build();
				response.add(confirmInvalidNumber);	
			});
			
			numeros.getRepeatedNumbers().forEach(repeatedNumber -> {
					CampanhaConfirmacao confirmRepeteadNumber = CampanhaConfirmacao.builder()
					.createdDate(Date.from(Instant.now()))
					.shippingCode(getRandomNumber(1000, 9999))
					.number(repeatedNumber)
					.status(StatusEnum.REPETIDO)
					.build();
				response.add(confirmRepeteadNumber);
			});
			
			numeros.getValidNumbers().forEach(validNumber -> {
				CampanhaConfirmacao confirmValidNumber = CampanhaConfirmacao.builder()
						.createdDate(Date.from(Instant.now()))
						.shippingCode(getRandomNumber(1000, 9999))
						.number(validNumber)
						.status(StatusEnum.ATIVO)
						.build();
				response.add(confirmValidNumber);
			});
			
			repository.saveAll(response);	
		}
		
		return response.stream().map(m -> mapper.modelToResponse(m)).collect(Collectors.toList());
	}
	

	@Override
	public List<CampanhaConfirmacaoResponse> list(CampanhaConfirmacaoSearchFilter filter) {
		
		List<CampanhaConfirmacao> model = repository.findAll(filter);
		
		return model.stream().map(m -> mapper.modelToResponse(m)).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		
		CampanhaConfirmacao model = repository.findById(id).orElseThrow(() ->
			new EntidadeNaoEncontradaException("Número de ID: " + id + " não encontrado.") {});
		
		repository.delete(model);		
		
	}
	
	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
}
