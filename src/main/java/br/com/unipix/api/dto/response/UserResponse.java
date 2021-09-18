package br.com.unipix.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	@JsonProperty("nome")
	private String name;
	
	private String email;
	
	@JsonProperty("status")
	private boolean status;
}
