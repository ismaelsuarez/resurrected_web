package com.resurrected.controller;

import java.util.EnumSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.resurrected.enums.RawMaterials;
import com.resurrected.enums.Status;
import com.resurrected.error.ErrorService;
import com.resurrected.repository.ProductRepository;
import com.resurrected.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/productos")
	public String productos(ModelMap model, @RequestParam(required = false) String status) {

		// TODO: listar todos los productos => hacer paginable => agregar filtros.
		model.put("status", status);

		return "productos.html";
	}

}
