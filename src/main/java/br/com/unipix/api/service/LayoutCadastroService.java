package br.com.unipix.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.unipix.api.dto.request.LayoutCadastroRequest;
import br.com.unipix.api.dto.response.LayoutCadastroResponse;

public interface LayoutCadastroService {
	
	Page<LayoutCadastroResponse> findAll(Pageable pageable);

	List<LayoutCadastroResponse> findAll();

	LayoutCadastroResponse findById(Long id);

	LayoutCadastroResponse create(LayoutCadastroRequest request);

	LayoutCadastroResponse update(Long id, LayoutCadastroRequest request);

	void delete(Long id);
}
