package br.com.unipix.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unipix.api.dto.response.CampanhaConfirmacaoResponse;
import br.com.unipix.api.model.CampanhaConfirmacao;

@Component
public class CampanhaConfirmacaoMapper {

	
	@Autowired
	private ModelMapper mapper;
	
	public CampanhaConfirmacaoResponse modelToResponse (CampanhaConfirmacao model) {
		
		return mapper.map(model, CampanhaConfirmacaoResponse.class);
	}
}
