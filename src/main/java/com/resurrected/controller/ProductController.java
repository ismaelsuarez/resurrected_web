package com.resurrected.controller;

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
	
	@GetMapping("/producto")
	public String produc() {
		return "redirect:/back/inicio";
	}
	
	
	// @PreAuthorize("hasAnyRole('ROLE_USER_ADMIN')")
	@PostMapping("/producto")
	public String regisProduct(ModelMap model,@RequestParam MultipartFile file,@RequestParam String name,@RequestParam Status status, @RequestParam String size,@RequestParam String category,
			@RequestParam String description,@RequestParam RawMaterials rawMaterials, @RequestParam Double cost,@RequestParam Double price,
			@RequestParam Integer stock, @RequestParam Double iva) {

		try {
			
			productService.createProduct(file, name, status, size, category, description, rawMaterials, cost, price, stock, iva);
			
			
		} catch (ErrorService ex) {
			model.put("error", ex.getMessage());
			model.put("name", name);
			model.put("status", status);
			model.put("size", size);
			model.put("category", category);
			model.put("rawMaterials", rawMaterials);
			model.put("cost", cost);
			model.put("price", price);
			model.put("stock", stock);
			model.put("iva", iva);
			model.put("file", file);
			
			return "redirect:/back/inicio";
		}
		
		return "redirect:/back/inicio";
	}
	
	// @PreAuthorize("hasAnyRole('ROLE_USER_ADMIN')")
	@PostMapping("/edit_producto")
	public String editProduct(ModelMap model,@RequestParam String id,@RequestParam MultipartFile file,@RequestParam String name,@RequestParam Status status, @RequestParam String size,@RequestParam String category,
			@RequestParam String description,@RequestParam RawMaterials rawMaterials, @RequestParam Double cost,@RequestParam Double price,
			@RequestParam Integer stock, @RequestParam Double iva) {

		try {
			
			productService.editProduct(id, file, name, status, size, description, rawMaterials, cost, price, stock, iva);
			
			
		} catch (ErrorService ex) {
			model.put("error", ex.getMessage());
			model.put("name", name);
			model.put("status", status);
			model.put("size", size);
			model.put("category", category);
			model.put("rawMaterials", rawMaterials);
			model.put("cost", cost);
			model.put("price", price);
			model.put("stock", stock);
			model.put("iva", iva);
			model.put("file", file);
			
			return "redirect:/back/inicio";
		}
		
		return "redirect:/back/inicio";
	}

}
