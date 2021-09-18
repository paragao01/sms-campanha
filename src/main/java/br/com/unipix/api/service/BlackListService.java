package br.com.unipix.api.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.unipix.api.dto.response.BlackListResponse;
import br.com.unipix.api.model.BlackList;

public interface BlackListService {
	
	Page<BlackListResponse> findAll(Specification<BlackList> spec ,Pageable pageable);
}
