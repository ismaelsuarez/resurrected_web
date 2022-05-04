package com.resurrected.controller;

import java.util.EnumSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.resurrected.enums.RawMaterials;
import com.resurrected.enums.Status;
import com.resurrected.service.ProductService;

@Controller
@RequestMapping("/admin")
public class IndexAdminController {
	

	private final ProductService productService;

	public IndexAdminController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/inicio")
	public String inicio(ModelMap model) {
		
		Set<Status> estados = EnumSet.allOf(Status.class);
        model.put("estados", estados);
        
        Set<RawMaterials> materiales = EnumSet.allOf(RawMaterials.class);
        model.put("materiales", materiales);
		
		return "back/inicio.html";
	}
	
	
}
