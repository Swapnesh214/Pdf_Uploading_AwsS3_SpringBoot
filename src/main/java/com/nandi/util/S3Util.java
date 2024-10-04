package com.nandi.util;

import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;

@Service
public class S3Util {

	@Value("${bucketName}")
	private String bucketName;

	private final AmazonS3 s3;

	public S3Util(AmazonS3 s3) {
		this.s3 = s3;
	}

	public String saveFile(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();

		try (InputStream inputStream = file.getInputStream()) {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(file.getSize());
			metadata.setContentType(file.getContentType());

			PutObjectResult putObjectResult = s3.putObject(bucketName, originalFilename, inputStream, metadata);
			return putObjectResult.getContentMd5();
		} catch (IOException e) {
			throw new RuntimeException("Failed to save file: " + originalFilename, e);
		}
	}
}
