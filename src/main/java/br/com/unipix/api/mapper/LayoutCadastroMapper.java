package br.com.unipix.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unipix.api.dto.request.LayoutCadastroRequest;
import br.com.unipix.api.dto.response.LayoutCadastroResponse;
import br.com.unipix.api.model.LayoutCadastro;

@Component
public class LayoutCadastroMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public LayoutCadastroResponse modelToResponse(LayoutCadastro model) {
		return mapper.map(model, LayoutCadastroResponse.class);
	}
	
	public LayoutCadastro requestToModel(LayoutCadastroRequest request) {
		return mapper.map(request, LayoutCadastro.class);
	}
}
