package br.com.unipix.api.dto.request;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	@JsonProperty("nome")
	private String name;
	
	@Email
	private String email;
	
	@JsonProperty("senha")
	private String password;
	
	@JsonProperty("confirmarSenha")
	private String confirmPassword;
}
