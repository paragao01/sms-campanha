package br.com.unipix.api.repository;

import java.util.List;

import br.com.unipix.api.filter.CampanhaConfirmacaoSearchFilter;
import br.com.unipix.api.model.CampanhaConfirmacao;

public interface CampanhaConfirmacaoFilterRepository {
	
	List<CampanhaConfirmacao> findAll(CampanhaConfirmacaoSearchFilter filter);

}
