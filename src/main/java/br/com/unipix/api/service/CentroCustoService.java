package br.com.unipix.api.service;

import java.util.List;

import br.com.unipix.api.dto.request.CentroCustoRequest;
import br.com.unipix.api.dto.response.CentroCustoResponse;

public interface CentroCustoService {

	CentroCustoResponse create (CentroCustoRequest request);
	
	CentroCustoResponse update (CentroCustoRequest request, Long id);
	
	void delete (Long id);
	
	CentroCustoResponse findById (Long id);
	
	List<CentroCustoResponse> findByParameter(String parameter);
	
	List<CentroCustoResponse> list ();
	
}
