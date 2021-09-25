package br.com.unipix.api.service;

import java.util.List;

import br.com.unipix.api.dto.response.NumeroCampanhaValidado;

public interface CampaignNumberValidationService {
	NumeroCampanhaValidado validationCampaing(List<String> phones);
}
