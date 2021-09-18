package br.com.unipix.api.service;

import java.util.HashMap;
import java.util.List;

import br.com.unipix.api.dto.request.TemplateMensagemRequest;
import br.com.unipix.api.dto.response.TemplateMensagemResponse;
import br.com.unipix.api.enumaration.VariavelEnum;

public interface TemplateMensagemService {
	
	TemplateMensagemResponse create(TemplateMensagemRequest request);
	
	TemplateMensagemResponse update(TemplateMensagemRequest request, Long id);
	
	List<TemplateMensagemResponse> list();
	
	List<TemplateMensagemResponse> findByParameter(String parameter);
	
	TemplateMensagemResponse findById(Long id);
	
	HashMap<VariavelEnum, String> listVariables();
	
	void delete(Long id);

}
