package br.com.unipix.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.unipix.api.model.BlackList;

@Repository
public interface BlackListRepository extends JpaRepository<BlackList, Long>, BlackListFilterRepository{
	
	@Query("FROM BlackList b WHERE b.centroCusto.id = :id")
	public Page<BlackList> findAll(Pageable page, Long id);
	
}
