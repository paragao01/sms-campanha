package br.com.unipix.api.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.unipix.api.filter.CampanhaConfirmacaoSearchFilter;
import br.com.unipix.api.model.CampanhaConfirmacao;
import br.com.unipix.api.repository.CampanhaConfirmacaoFilterRepository;

@Repository
public class CampanhaConfirmacaoFilterRepositoryImpl implements CampanhaConfirmacaoFilterRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<CampanhaConfirmacao> findAll(CampanhaConfirmacaoSearchFilter filter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CampanhaConfirmacao> criteria = builder.createQuery(CampanhaConfirmacao.class);
		Root<CampanhaConfirmacao> root = criteria.from(CampanhaConfirmacao.class);

		List<Predicate> predicates = new ArrayList<>();

		if(Objects.nonNull(filter.getCampaign())) {
			predicates.add(builder.equal(root.get("id"), filter.getCampaign()));
		}
		
		if(Objects.nonNull(filter.getStatus())) {
			predicates.add(builder.equal(root.get("status"), filter.getStatus()));
		}
		
		if(Objects.nonNull(filter.getDate())) {
			predicates.add(builder.equal(root.get("createdDate"), filter.getDate()));
		}

		criteria.where(predicates.toArray(new Predicate[0]));
		TypedQuery<CampanhaConfirmacao> query = manager.createQuery(criteria);

		return query.getResultList();
	}

}
