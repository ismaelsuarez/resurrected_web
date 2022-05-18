package com.resurrected.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {
	
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
