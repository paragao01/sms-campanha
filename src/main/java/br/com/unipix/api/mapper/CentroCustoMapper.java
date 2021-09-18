package br.com.unipix.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unipix.api.dto.request.CentroCustoRequest;
import br.com.unipix.api.dto.response.CentroCustoResponse;
import br.com.unipix.api.model.CentroCusto;

@Component
public class CentroCustoMapper {

	@Autowired
	private ModelMapper mapper;
	
	public CentroCusto requestToModel(CentroCustoRequest request) {
		
		return mapper.map(request, CentroCusto.class);
	}
	
	public CentroCustoResponse modelToResponse(CentroCusto model) {
		
		return mapper.map(model, CentroCustoResponse.class);
	}
}
