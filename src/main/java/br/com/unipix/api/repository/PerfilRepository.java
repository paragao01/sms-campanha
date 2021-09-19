package br.com.unipix.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unipix.api.model.Grupo;

public interface PerfilRepository extends JpaRepository<Grupo, Long>{

}