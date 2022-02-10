package com.resurrected.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.resurrected.entity.Photo;
import com.resurrected.entity.Product;
import com.resurrected.enums.RawMaterials;
import com.resurrected.enums.Status;
import com.resurrected.error.ErrorService;
import com.resurrected.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PhotoService photoService;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Product createProduct(MultipartFile file, String name, String waist, String description,
			RawMaterials rawMaterials, Double cost, Double price, Integer stock, Double iva) throws ErrorService {

		Product product = new Product();
		product.setName(name);
		product.setWaist(waist);
		product.setDescription(description);
		product.setRawMaterials(rawMaterials);
		product.setCost(cost);
		product.setPrice(price);
		product.setStock(stock);
		product.setIva(iva);
		product.setCreateDate(new Date());
		Photo photo = photoService.multiPartToEntity(file);
		product.setPhoto(photo);

		return productRepository.save(product);

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Product editProduct(String idProduct, MultipartFile file, String name, String waist, String description,
			RawMaterials rawMaterials, Double cost, Double price, Integer stock, Double iva) throws ErrorService {

		Optional<Product> checkP = productRepository.findById(idProduct);

		if (checkP != null) {

			Product product = checkP.get();
			product.setName(name);
			product.setWaist(waist);
			product.setDescription(description);
			product.setRawMaterials(rawMaterials);
			product.setCost(cost);
			product.setPrice(price);
			product.setStock(stock);
			product.setIva(iva);
			product.setCreateDate(new Date());
			Photo photo = photoService.multiPartToEntity(file);
			product.setPhoto(photo);

			return productRepository.save(product);

		} else {
			throw new ErrorService("No se encuentra el id, para poder editar el producto");

		}
	}

	@Transactional
	public List<Product> listCheck(String id) {
		Optional<Product> check = productRepository.findById(id);
		List<Product> list = new ArrayList<>();
		if (check != null) {
			Product product = check.get();
			list.add(product);
		}

		return list;

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void removeProduct(String idProduct) throws ErrorService {

		Optional<Product> check = productRepository.findById(idProduct);
		if (check != null) {
			Product product = check.get();
			productRepository.delete(product);
		} else {

			throw new ErrorService("No se encuentra el id del producto a eliminar");
		}

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Product active(String idProduct) throws ErrorService {
		Optional<Product> check = productRepository.findById(idProduct);
		Product product = check.get();
		product.setStatus(Status.Disponible);
		return productRepository.save(product);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Product passive(String idProduct) throws ErrorService {
		Optional<Product> check = productRepository.findById(idProduct);
		Product product = check.get();
		product.setStatus(Status.Agotado);
		return productRepository.save(product);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Product coming(String idProduct) throws ErrorService {
		Optional<Product> check = productRepository.findById(idProduct);
		Product product = check.get();
		product.setStatus(Status.Proximamente);
		return productRepository.save(product);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Product pending(String idProduct) throws ErrorService {
		Optional<Product> check = productRepository.findById(idProduct);
		Product product = check.get();
		product.setStatus(Status.Pendiente);
		return productRepository.save(product);
	}
	
	
	
	
//
//	@Transactional(readOnly = true)
//	public List<Product> findTrue() {
//		return productRepository.findTrue();
//	}
//
//	@Transactional(readOnly = true)
//	public List<Product> findFalse() {
//		return productRepository.findFalse();
//	}
//
//	@Transactional(readOnly = true)
//	public List<Product> findAll() {
//		return productRepository.findAll();
//	}
//
//	@Transactional(readOnly = true)
//	public List<Product> findAllS() {
//		return productRepository.findAllS();
//	}
//
//	@Transactional(readOnly = true)
//	public Product findId(String idProduct) {
//		return productRepository.findId(idProduct);
//	}

	@Transactional(readOnly = true)
	public Optional<Product> findIdP(String idProduct) {
		return productRepository.findById(idProduct);
	}

}
