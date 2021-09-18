package br.com.unipix.api.dto.request;

import java.sql.Blob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlackListRequest {

	private Long centroCusto;
	
	private Blob anexo;
	
	private String manual;
	
}
