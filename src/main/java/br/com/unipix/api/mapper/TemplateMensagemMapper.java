package br.com.unipix.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unipix.api.dto.request.TemplateMensagemRequest;
import br.com.unipix.api.dto.response.TemplateMensagemResponse;
import br.com.unipix.api.model.TemplateMensagem;

@Component
public class TemplateMensagemMapper {

	@Autowired
	private ModelMapper mapper;
	
	public TemplateMensagem requestToModel(TemplateMensagemRequest request) {
		
		return mapper.map(request, TemplateMensagem.class);
	}
	
	public TemplateMensagemResponse modelToResponse(TemplateMensagem model) {
		
		return mapper.map(model, TemplateMensagemResponse.class);
	}
	
}
