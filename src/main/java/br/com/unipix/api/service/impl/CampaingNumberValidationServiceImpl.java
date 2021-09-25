package br.com.unipix.api.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipix.api.dto.response.NumeroCampanhaValidado;
import br.com.unipix.api.model.Manual;
import br.com.unipix.api.repository.ManualRepository;
import br.com.unipix.api.service.CampaignNumberValidationService;

@Service
public class CampaingNumberValidationServiceImpl implements CampaignNumberValidationService{
	
	@Autowired
	private ManualRepository manualRepository;

	
	@Override
	public NumeroCampanhaValidado validationCampaing(List<String> phones) {
		List<Manual> blackLists = manualRepository.findAll();
		
		List<String> invalidNumbers = new ArrayList<>();
		List<String> blackList = new ArrayList<>();
		List<String> validNumbers = new ArrayList<>();
		List<String> repeatedNumbers = new ArrayList<>();
		List<String> numbers = new ArrayList<>();
		
		for (String phone : phones) { 
			int ddd = Integer.parseInt(phone.substring(0, 2));
			
			if(phone.length() < 11 || phone.length() > 11 || dddInexistente(ddd) == true) {
				if(invalidNumbers.stream().filter(b -> b.equals(phone)).findFirst().isEmpty()) {					
					invalidNumbers.add(phone);
					continue;
				}
				repeatedNumbers.add(phone);
				continue;
			}
			if(!blackLists.stream().filter(m -> m.getManual().equals(phone)).findFirst().isEmpty()) {
				if(blackList.stream().filter(b -> b.equals(phone)).findFirst().isEmpty()) {					
					blackList.add(phone);
					continue;
				}
				repeatedNumbers.add(phone);
				continue;
			}
			if(numbers.stream().filter(n -> n.equals(phone)).findFirst().isEmpty() == false){
				repeatedNumbers.add(phone);
				continue;
			}	
			numbers.add(phone);
			
			validNumbers.add(phone);
		}
		
		return NumeroCampanhaValidado.builder()
				.amoutInvalidNumbers(Long.valueOf(invalidNumbers.size()))
				.blacklist(blackList)
				.invalidatedNumbers(invalidNumbers)
				.quantityBlacklist(Long.valueOf(blackList.size()))
				.quantityValidNumbers(Long.valueOf(validNumbers.size()))
				.repeatedNumbers(repeatedNumbers)
				.quantityRepeatedNumbers(Long.valueOf(repeatedNumbers.size()))
				.validNumbers(validNumbers)
				.build();
	}
	
	
	public boolean dddInexistente(int ddd) {
		
		
		List<Integer> dddInvalidos = Arrays.asList(20, 23, 25, 26, 29, 30, 36, 39
				, 40, 50, 52, 56, 57, 58, 59, 60, 70, 72, 76, 78, 80, 90);
		
		boolean dddInvalido = dddInvalidos.stream().anyMatch(valor -> valor == ddd);
		return dddInvalido;
		
	}

}
