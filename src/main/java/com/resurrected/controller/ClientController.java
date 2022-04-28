package com.resurrected.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.resurrected.entity.Client;
import com.resurrected.error.ErrorService;
import com.resurrected.mapper.ClientMapper;
import com.resurrected.model.ClientRegisterModel;
import com.resurrected.repository.ClientRepository;
import com.resurrected.service.ClientService;

@Controller
@RequestMapping("/")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private ClientMapper clientmapper;

	@GetMapping("/registrate")
	public String registrate() {
		return "registrate.html";
	}
	@GetMapping("/producto")
	public String producto() {
		return "product.html";
	}
	@GetMapping("/inicio")
	public String inicio() {
		return "inicio.html";
	}

	@GetMapping("/editarproducto")
	public String productstock() {
		return "product-stock.html";
	}

	@PreAuthorize("hasAnyRole('ROLE_USER_CLIENT','ROLE_USER_ADMIN')")
	@GetMapping("/perfil")
	public String perfil() {
		return "perfil.html";
	}

	@PreAuthorize("hasAnyRole('ROLE_USER_CLIENT','ROLE_USER_ADMIN')")
	@GetMapping("/edit")
	public String edit(ModelMap model, HttpSession session) {
		Client u = (Client) session.getAttribute("sessionuser");
		Optional<Client> check = clientRepository.findById(u.getId());

		Client client = check.get();
		model.put("id", u.getId());
		model.put("name", client.getName());
		model.put("lastname", client.getLastname());
		model.put("email", client.getEmail());

		return "edit.html";
	}

	@PostMapping("/edit")
	public String edit(@RequestParam String id, MultipartFile file, @RequestParam String name,
			@RequestParam String lastname, @RequestParam Long document, @RequestParam String phoneNumber,
			@RequestParam String address, @RequestParam String email, @RequestParam String password1,
			@RequestParam String password2) {

		try {
			clientService.editClient(id, file, name, lastname, document, phoneNumber, address, email, password1,
					password2);
		} catch (ErrorService e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/perfil";
	}

	@PostMapping("/registrar")
	public String register(ModelMap model, @RequestParam String name, @RequestParam String lastname, @RequestParam String email, @RequestParam String password) {

		try {
			
			ClientRegisterModel registerModel = clientmapper.convertToModel(name, lastname, email, password);
			
			clientService.createClient(registerModel);

			return "index.html";
		} catch (ErrorService ex) {

			model.put("error", ex.getMessage());
			model.put("name", name);
			model.put("lastname", lastname);
			model.put("email", email);

			return "registrate.html";

		}

	}
	
	@GetMapping("/login")
	public String login(Model model, @RequestParam(required = false) String error,@RequestParam(required = false) String email, @RequestParam(required = false) String logout) {
		if(error != null) {
			model.addAttribute("error", "El usuario o contraseña son incorrectas");	
		}
		if(email != null) {
			model.addAttribute("nombre", email);
		}
		
		return"index";
	}

}
