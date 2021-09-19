package br.com.unipix.api.dto.request;

import java.sql.Blob;

import br.com.unipix.api.model.Anexo;
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
	
	private AnexoIdRequest anexo;
	
	private String manual;
	
}
