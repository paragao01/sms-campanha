package br.com.unipix.api.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.unipix.api.dto.response.BlackListResponse;
import br.com.unipix.api.filter.BlackListFilter;

public interface BlackListService {
	
	Page<BlackListResponse> findAll(Pageable pageable, BlackListFilter filter);
}
