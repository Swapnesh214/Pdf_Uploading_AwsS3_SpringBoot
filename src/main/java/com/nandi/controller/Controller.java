package com.nandi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nandi.service.Service;

@RestController
@RequestMapping
public class Controller {
	
	@Autowired
	private Service impl;

	@GetMapping("/")
	public String loadForm() {
		return "upload";
	}

	@PostMapping("/upload")
	public String handleUploadForm(Model model, @RequestParam("file") MultipartFile multipart) {
		String message = "";
		try {
			message = impl.handleUploadForm(multipart);
		} catch (Exception ex) {
			message = "Error uploading file: " + ex.getMessage();
		}
		model.addAttribute("message", message);
		return message;
	}
}
