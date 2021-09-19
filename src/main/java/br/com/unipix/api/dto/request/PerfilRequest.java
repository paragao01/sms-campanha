package br.com.unipix.api.dto.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.unipix.api.enumaration.StatusEnum;
import br.com.unipix.api.model.Permissao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilRequest {
	
	@NotNull
	@NotBlank
	@JsonProperty(value = "nome")
	private String name;

	@JsonProperty(value = "status")
	private StatusEnum status;

	@JsonProperty("permissoes")
	private List<Permissao> permissions;
}