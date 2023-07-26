package com.nandi.service;

import org.springframework.web.multipart.MultipartFile;

public interface PersonService {

	public String handleUploadForm( MultipartFile multipart);
}
