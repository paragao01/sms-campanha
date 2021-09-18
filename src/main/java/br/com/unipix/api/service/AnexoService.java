package br.com.unipix.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import br.com.unipix.api.model.Anexo;

public interface AnexoService {

	Page<Anexo> findAll(Pageable pageable);

	List<Anexo> findAll();

	Anexo findById(Long id);

	Anexo create(MultipartFile file);

	Anexo update(Long id, MultipartFile file);

	void delete(Long id);
}
