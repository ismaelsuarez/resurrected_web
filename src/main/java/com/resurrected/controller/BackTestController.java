package com.resurrected.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/back")
public class BackTestController {

	@GetMapping("/inicio")
	public String inicio() {
		return "back/inicio.html";
	}
	
	@GetMapping("/productos")
	public String productos(ModelMap model, @RequestParam(required = false) String status) {
		
		//TODO: listar todos los productos => hacer paginable => agregar filtros.
		model.put("status", status);
		
		
		return "back/productos.html";
	}
	
}
