package com.nandi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.nandi.service.Service;
import com.nandi.util.S3Util;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	
	@Autowired
	private S3Util s3Util;

	@Override
	public String handleUploadForm(MultipartFile multipart) {
		return s3Util.saveFile(multipart);
	}

}
