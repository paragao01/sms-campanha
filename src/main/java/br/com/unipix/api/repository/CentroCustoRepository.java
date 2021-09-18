package br.com.unipix.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.unipix.api.model.CentroCusto;

@Repository
public interface CentroCustoRepository extends JpaRepository<CentroCusto, Long> {


	@Query("FROM CentroCusto c WHERE c.name LIKE %:name% OR c.id LIKE %:name%")
	List<CentroCusto> findByPameter(@Param("name") String name);
	

}
