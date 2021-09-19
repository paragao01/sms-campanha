package br.com.unipix.api.repository.impl;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.unipix.api.filter.BlackListFilter;
import br.com.unipix.api.model.BlackList;
import br.com.unipix.api.repository.BlackListFilterRepository;

@Repository
public class BlackListFilterRepositoryImpl implements BlackListFilterRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	public Page<BlackList> findAll(BlackListFilter filter, Pageable pageable){
		StringBuilder jpql = new StringBuilder();
		HashMap<String, Object> parameter = new HashMap<String, Object>();
		
		jpql.append("from BlackList b where 0=0 ");
		
		if(filter.getCentroCusto() != null) {
			jpql.append("and b.centroCusto.id = :parameter");
			parameter.put("parameter", filter.getCentroCusto());
		}
		
		TypedQuery<BlackList> query = manager.createQuery(jpql.toString(), BlackList.class);
		parameter.forEach((key, value) -> query.setParameter(key, value));
		Long size = Long.valueOf(query.getResultList().size());
		query.setFirstResult((int)pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		Page<BlackList> page = new PageImpl<>(query.getResultList(), pageable, size);
		
		return page;
	}
}
