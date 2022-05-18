package com.resurrected.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.resurrected.repository.ProductRepository;
import com.resurrected.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {


	private final ProductService productService;
	private final ProductRepository productRepository;

	public ProductController(ProductService productService, ProductRepository productRepository) {
		this.productService = productService;
		this.productRepository = productRepository;
	}

	@GetMapping("/productos")
	public String productos(ModelMap model, @RequestParam(required = false) String status) {

		// TODO: listar todos los productos => hacer paginable => agregar filtros.
		model.put("status", status);

		return "productos.html";
	}

}
