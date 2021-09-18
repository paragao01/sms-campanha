package br.com.unipix.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.unipix.api.model.BlackList;

@Repository
public interface BlackListRepository extends JpaRepository<BlackList, Long>, JpaSpecificationExecutor<BlackList>{

}
