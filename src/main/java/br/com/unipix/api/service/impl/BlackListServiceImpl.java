package br.com.unipix.api.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.unipix.api.dto.response.BlackListResponse;
import br.com.unipix.api.filter.BlackListFilter;
import br.com.unipix.api.mapper.BlackListMapper;
import br.com.unipix.api.model.BlackList;
import br.com.unipix.api.repository.BlackListRepository;
import br.com.unipix.api.service.BlackListService;

@Service
public class BlackListServiceImpl implements BlackListService{

	@Autowired
	private BlackListRepository repository;
	
	@Autowired
	private BlackListMapper mapper;
	
	@Override
	public Page<BlackListResponse> findAll(Pageable pageable, BlackListFilter filter) {
		Page<BlackList> blackList = repository.findAll(filter, pageable);
		return blackList.map(b -> mapper.modelToResponse(b));
	}

}
