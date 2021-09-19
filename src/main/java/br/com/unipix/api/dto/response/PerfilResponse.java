package br.com.unipix.api.dto.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.unipix.api.enumaration.StatusEnum;
import br.com.unipix.api.model.Permissao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilResponse {
	
	@JsonProperty(value = "id")
	private Long id;
	
	@JsonProperty(value = "nome")
	private String name;

	@JsonProperty(value = "status")
	private StatusEnum status;
	
	@JsonProperty("permissoes")
	private List<Permissao> permissions;

	@JsonProperty("dataCriacao")
	private Date createDate;

}