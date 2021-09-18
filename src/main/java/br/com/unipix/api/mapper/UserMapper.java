package br.com.unipix.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unipix.api.dto.request.UserRequest;
import br.com.unipix.api.dto.response.UserResponse;
import br.com.unipix.api.model.User;

@Component
public class UserMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public UserResponse modelToDto(User user) {
		return mapper.map(user, UserResponse.class);
	}

	public List<UserResponse> modelsToCollectionDtoResponse(List<User> user) {
		return user.stream().map(u -> modelToDto(u)).collect(Collectors.toList());
				
	}
	
	public User dtoToModel(UserRequest user) {
		return mapper.map(user, User.class);
	}
}
