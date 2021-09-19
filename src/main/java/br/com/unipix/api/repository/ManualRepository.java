package br.com.unipix.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipix.api.model.Manual;

@Repository
public interface ManualRepository extends JpaRepository<Manual, Long>{

}
