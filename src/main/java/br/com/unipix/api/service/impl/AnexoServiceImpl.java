package br.com.unipix.api.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.unipix.api.exception.BusinessException;
import br.com.unipix.api.model.Anexo;
import br.com.unipix.api.repository.AnexoRepository;
import br.com.unipix.api.service.AnexoService;
import br.com.unipix.api.service.FileStorageService;

@Service
public class AnexoServiceImpl implements AnexoService{
	
	@Autowired
	private AnexoRepository repository;
	
	@Autowired
	private FileStorageService storageService;
	
	public Page<Anexo> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public List<Anexo> findAll() {
		return repository.findAll();
	}
	
	public Anexo findById(Long id) {
		Anexo model = repository.findById(id).orElseThrow(() -> new BusinessException(String.format("Arquivo de código: %d não encontrado.", id)));
		return model;
	}
	
	public Anexo create(MultipartFile file) {
		String filepath = storageService.saveFile(file);
		Anexo model = Anexo.builder()
				.name(file.getOriginalFilename())
				.size(file.getSize())
				.url(filepath)
				.build();
		
		Anexo savedModel = repository.save(model);
		return savedModel;
	}
	
	public Anexo update(Long id, MultipartFile file) {
		Anexo model = repository.findById(id).orElseThrow(() -> new BusinessException(String.format("Arquivo de código: %d não encontrado.", id)));
		storageService.deleteFile(model.getUrl());
		
		String filepath = storageService.saveFile(file);
		model.setName(file.getOriginalFilename());
		model.setSize(file.getSize());
		model.setUrl(filepath);
		
		Anexo savedModel = repository.save(model);
		return savedModel;
	}
	
	public void delete(Long id) {
		Anexo model = repository.findById(id).orElseThrow(() -> new BusinessException(String.format("Arquivo de código: %d não encontrado.", id)));
		storageService.deleteFile(model.getUrl());
		repository.delete(model);
	}
	
	
}
