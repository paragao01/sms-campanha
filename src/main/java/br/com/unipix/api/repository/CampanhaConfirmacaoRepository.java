package br.com.unipix.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipix.api.model.CampanhaConfirmacao;

@Repository
public interface CampanhaConfirmacaoRepository extends JpaRepository<CampanhaConfirmacao, Long>, CampanhaConfirmacaoFilterRepository{

	@Override
	List<CampanhaConfirmacao> findAll();
}
