package br.com.unipix.api.service;

import java.util.List;

import br.com.unipix.api.dto.response.CampanhaConfirmacaoResponse;
import br.com.unipix.api.dto.response.NumeroCampanhaValidado;
import br.com.unipix.api.filter.CampanhaConfirmacaoSearchFilter;

public interface CampanhaConfirmacaoService {

	List<CampanhaConfirmacaoResponse> build(NumeroCampanhaValidado numeros);
	
	List<CampanhaConfirmacaoResponse> list(CampanhaConfirmacaoSearchFilter filter);
	
	void delete(Long id);
}
