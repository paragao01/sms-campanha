package br.com.unipix.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.unipix.api.filter.BlackListFilter;
import br.com.unipix.api.model.BlackList;

public interface BlackListFilterRepository {

	Page<BlackList> findAll(BlackListFilter filter, Pageable pageable);
}
