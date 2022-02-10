package com.resurrected.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.resurrected.error.ErrorService;
import com.resurrected.service.ClientService;



@Controller
@RequestMapping("/")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/registrate")
	public String registrate() {
		return "registrate.html";
	}
	
	@PostMapping("/registrate")
	public String register(ModelMap model, @RequestParam String name, @RequestParam String lastname,
			@RequestParam String email, @RequestParam String password1, @RequestParam String password2,
			@RequestParam MultipartFile file) {

		
		try {
			clientService.createClient(name, lastname, email, password1, password2, file);

			return "index.html";
		} catch (ErrorService ex) {

			model.put("error", ex.getMessage());
			model.put("name", name);
			model.put("email", email);
			model.put("password1", password1);
			model.put("password2", password2);
			model.put("file", file);

			return "registrate.html";

		}

	}


}
