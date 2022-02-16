package com.resurrected.controller;

import java.util.EnumSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.resurrected.service.ProductService;

@Controller
@RequestMapping("/back")
public class BackTestController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/inicio")
	public String inicio(ModelMap model) {
		
		Set<Status> estados = EnumSet.allOf(Status.class);
        model.put("estados", estados);
        
        Set<RawMaterials> materiales = EnumSet.allOf(RawMaterials.class);
        model.put("materiales", materiales);
		
		return "back/inicio.html";
	}
	
	@GetMapping("/productos")
	public String productos(ModelMap model, @RequestParam(required = false) String status) {
		
		//TODO: listar todos los productos => hacer paginable => agregar filtros.
		model.put("status", status);
		
		
		return "back/productos.html";
	}
	
	
	@PostMapping("/producto")
	public String regisProduct(ModelMap model,
			@RequestParam(required=false) MultipartFile file,
			@RequestParam String name,
			@RequestParam String status,
			@RequestParam String size,
			@RequestParam String category,
			@RequestParam String description,
			@RequestParam String rawMaterials,
			@RequestParam String cost,
			@RequestParam String price,
			@RequestParam String stock, 
			@RequestParam String iva) {

		try {
			
			System.out.println("ENTRO");
			
			System.out.println(Status.valueOf(status));
			System.out.println(Double.valueOf(cost));
			System.out.println(Double.valueOf(price));
			System.out.println(Integer.valueOf(stock));
			System.out.println(Double.valueOf(iva));
			
			productService.createProduct(file,
					name,
					Status.valueOf(status),
					size,
					category,
					description,
					RawMaterials.valueOf(rawMaterials),
					Double.valueOf(cost),
					Double.valueOf(price),
					Integer.valueOf(stock),
					Double.valueOf(iva));
			
			
		} catch (Exception ex) {
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
			
			return this.inicio(model);
		}
		
		return this.inicio(model);
	}
	
	
	
	
	
	
}
