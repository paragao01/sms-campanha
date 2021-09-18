package br.com.unipix.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.unipix.api.model.TemplateMensagem;

@Repository
public interface TemplateMensagemRepository extends JpaRepository<TemplateMensagem, Long> {

	@Query("FROM TemplateMensagem t WHERE t.name LIKE %:name% OR t.id LIKE %:name%")
	List<TemplateMensagem> findByParameter(@Param("name") String name);
}
