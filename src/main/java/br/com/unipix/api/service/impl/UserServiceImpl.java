package br.com.unipix.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unipix.api.dto.request.UserRequest;
import br.com.unipix.api.dto.response.UserResponse;
import br.com.unipix.api.enums.StatusEnum;
import br.com.unipix.api.exception.BusinessException;
import br.com.unipix.api.mapper.UserMapper;
import br.com.unipix.api.model.User;
import br.com.unipix.api.repository.UserRepository;
import br.com.unipix.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User searchOrFail(Long id) {
		return repository.findById(id).orElseThrow(() ->
			new BusinessException(String.format("Usuário com id %d, não encontrado", id)));
	}
	
	@Override
	public Page<UserResponse> findAll(Specification<User> spec, Pageable pageable) {
		Page<User> users = repository.findAll(spec, pageable);
		return users.map(u -> userMapper.modelToDto(u));
	}

	@Override
	public UserResponse findById(Long id) {
		User user = searchOrFail(id);
		return userMapper.modelToDto(user);
	}
	
	@Override
	@Transactional
	public UserResponse save(UserRequest user) {
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			throw new BusinessException("As Senhas não coincidem");
		}
		User userModel = User.builder()
				.email(user.getEmail())
				.name(user.getName())
				.password(passwordEncoder.encode(user.getConfirmPassword()))
				.status(StatusEnum.ATIVO)
				.build();
				
		User userSaved = repository.save(userModel);
		
		return userMapper.modelToDto(userSaved);
	}

	@Override
	@Transactional
	public UserResponse update(UserRequest user, Long id) {
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			throw new BusinessException("As Senhas não coincidem");
		}
		User existingUser = searchOrFail(id);
		User userUpdate = User.builder()
				.id(id)
				.email(user.getEmail())
				.name(user.getName())
				.status(StatusEnum.ATIVO)
				.password(passwordEncoder.encode(user.getConfirmPassword())).build();
		User userSaved = repository.save(userUpdate);
		return userMapper.modelToDto(userSaved);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		User existingUser = searchOrFail(id);
		try {
			repository.deleteById(id);
		}catch (Exception e) {
			throw new BusinessException("Usuário em uso");
		}
		
	}

	@Override
	public UserResponse activate(Long id) {
		User existingUser = searchOrFail(id);
		existingUser.setStatus(StatusEnum.ATIVO);
		
		return userMapper.modelToDto(repository.save(existingUser));
	}

	@Override
	public UserResponse disable(Long id) {
		User existingUser = searchOrFail(id);
		existingUser.setStatus(StatusEnum.INATIVO);
		
		return userMapper.modelToDto(repository.save(existingUser));
	}
	
	
	
}
