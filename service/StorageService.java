package com.proy.tallerDos.service;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

public interface StorageService {
	
   void init() throws IOException;
	
	String store(MultipartFile file);
	
	Resource loadAsResource(String filename);
	


}
