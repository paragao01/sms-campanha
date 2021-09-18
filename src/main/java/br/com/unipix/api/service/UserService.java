package br.com.unipix.api.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.unipix.api.dto.request.UserRequest;
import br.com.unipix.api.dto.response.UserResponse;
import br.com.unipix.api.model.User;

public interface UserService{

	public Page<UserResponse> findAll(Pageable pageable);
	
	public UserResponse findById(Long id);
	
	public UserResponse save(UserRequest user);
	
	public UserResponse update(UserRequest user, Long id);
	
	public void delete(Long id);

	public UserResponse activate(Long id);
	
	public UserResponse disable(Long id);
}
