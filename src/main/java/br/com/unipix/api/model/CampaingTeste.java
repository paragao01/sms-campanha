package br.com.unipix.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CampaingTeste {

	private Long id;
	
	private String telephone;
	
}
