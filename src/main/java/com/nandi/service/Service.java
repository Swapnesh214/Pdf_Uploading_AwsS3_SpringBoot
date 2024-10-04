package com.nandi.service;

import org.springframework.web.multipart.MultipartFile;

public interface Service {

	public String handleUploadForm(MultipartFile multipart);
}
