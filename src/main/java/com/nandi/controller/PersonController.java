package com.nandi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nandi.service.PersonService;

@RestController
@RequestMapping(name="/img")
public class PersonController {
	
	@Autowired
	private PersonService impl;

	@GetMapping("/")
	public String loadForm() {
		return "upload";
	}

	@PostMapping("/upload")
	public String handleUploadForm(Model model, @RequestParam("file") MultipartFile multipart) {
		String message = "";
		try {
			impl.handleUploadForm(multipart);
			message = "Your file has been uploaded successfully!";
		} catch (Exception ex) {
			message = "Error uploading file: " + ex.getMessage();
		}
		model.addAttribute("message", message);
		return "message";
	}

	
}
