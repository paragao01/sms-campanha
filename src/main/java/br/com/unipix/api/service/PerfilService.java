package br.com.unipix.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.unipix.api.dto.request.PerfilRequest;
import br.com.unipix.api.dto.response.PerfilResponse;

public interface PerfilService {
	
	Page<PerfilResponse> findAll(Pageable pageable);

	List<PerfilResponse> findAll();

	PerfilResponse findById(Long id);

	PerfilResponse create(PerfilRequest request);

	PerfilResponse update(Long id, PerfilRequest request);

	void delete(Long id);
}
