package br.com.unipix.api.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.unipix.api.exception.BusinessException;
import br.com.unipix.api.service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService {
	
	@Value("${api.storage.local.path}")
	private String StoragePath;

	public String saveFile(MultipartFile file) {
		//StoragePath = "C:\\";
		String fileName =  UUID.randomUUID().toString() + file.getOriginalFilename();
		Path filepath = Paths.get(StoragePath+fileName);
		try {
			Files.copy(file.getInputStream(),filepath , StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException("Erro ao salvar o arquivo");
		}

		return filepath.toAbsolutePath().toString();
	}

	public void deleteFile(String path) {
		try {
			Files.deleteIfExists(Paths.get(path).toAbsolutePath());
		} catch (Exception e) {
			throw new BusinessException("Erro ao deletar o arquivo");
		}

	}
}
