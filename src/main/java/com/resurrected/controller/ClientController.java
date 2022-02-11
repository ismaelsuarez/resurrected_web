package com.resurrected.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.resurrected.entity.Client;
import com.resurrected.entity.Photo;
import com.resurrected.enums.StatusClient;
import com.resurrected.error.ErrorService;
import com.resurrected.repository.ClientRepository;
import com.resurrected.service.ClientService;



@Controller
@RequestMapping("/")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/registrate")
	public String registrate() {
		return "registrate.html";
	}
	
	
	@GetMapping("/login")
	public String login() {
	return "login.html";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USER_CLIENT','ROLE_USER_ADMIN')")
	@GetMapping("/perfil")
	public String perfil() {
	return "perfil.html";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USER_CLIENT','ROLE_USER_ADMIN')")
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable String id) {		
		Optional<Client> check = clientRepository.findById(id);
		
		Client client = check.get();		
		model.put("id", id);
		model.put("name", client.getName());
		model.put("lastname", client.getLastname());
		model.put("email", client.getEmail());
		
		
	
		return "edit.html";
	}
	
	
	
	
	@PostMapping("/edit/{id}")
	public String editp(@PathVariable String id) {
		
		
		
		
		
		return "perfil.html";
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
