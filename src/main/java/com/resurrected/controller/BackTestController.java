package com.resurrected.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back")
public class BackTestController {

	@GetMapping("/inicio")
	public String inicio() {
		return "back/inicio.html";
	}
	
}
