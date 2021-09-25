package br.com.unipix.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NumeroCampanhaValidado {
	List<String> invalidatedNumbers;
	Long amoutInvalidNumbers;
	List<String> repeatedNumbers;
	Long quantityRepeatedNumbers;
	List<String> blacklist;
	Long quantityBlacklist;
	List<String> validNumbers;
	Long quantityValidNumbers;
}
