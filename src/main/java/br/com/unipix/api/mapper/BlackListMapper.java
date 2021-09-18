package br.com.unipix.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unipix.api.dto.response.BlackListResponse;
import br.com.unipix.api.model.BlackList;

@Component
public class BlackListMapper {

	@Autowired
	private ModelMapper mapper;
	
	public BlackListResponse modelToResponse(BlackList blackList) {
		return mapper.map(blackList, BlackListResponse.class);
	}
}
