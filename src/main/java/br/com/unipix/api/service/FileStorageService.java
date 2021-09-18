package br.com.unipix.api.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	
	 String saveFile(MultipartFile file);
	
	 void deleteFile(String path);
}
