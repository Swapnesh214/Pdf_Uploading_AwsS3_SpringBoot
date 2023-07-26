package com.nandi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.S3ArnUtils;
import com.nandi.service.PersonService;
import com.nandi.util.S3Util;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private S3Util s3Util;

	@Override
	public String handleUploadForm(MultipartFile multipart) {
		String message="";
		
		 	try {
		 		
		 	}catch (Exception e) {
				// TODO: handle exception
			}
		
		
		return null;
	}

}
