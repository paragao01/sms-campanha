package br.com.unipix.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unipix.api.dto.request.PerfilRequest;
import br.com.unipix.api.dto.response.PerfilResponse;
import br.com.unipix.api.model.Grupo;

@Component
public class PerfilMapper {
	
	@Autowired
	private ModelMapper mapper;

	public PerfilResponse modelToResponse(Grupo model) {
		return mapper.map(model, PerfilResponse.class);
	}

	public Grupo requestToModel(PerfilRequest request) {
		return mapper.map(request, Grupo.class);
	}
}
