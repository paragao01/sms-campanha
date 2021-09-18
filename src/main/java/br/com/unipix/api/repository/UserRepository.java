package br.com.unipix.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipix.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
}

