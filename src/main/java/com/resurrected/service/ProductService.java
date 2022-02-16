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
	public Product createProduct(MultipartFile file, String name, Status status, String size, String category,
			String description, RawMaterials rawMaterials, Double cost, Double price, Integer stock, Double iva)
			throws ErrorService {

		Product product = new Product();
		product.setName(name);
		product.setSize(size);
		product.setStatus(status);
		product.setCategory(category);
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
	public Product editProduct(String idProduct, MultipartFile file, String name, Status status, String size,
			String description, RawMaterials rawMaterials, Double cost, Double price, Integer stock, Double iva)
			throws ErrorService {

		Optional<Product> checkP = productRepository.findById(idProduct);

		if (checkP != null) {

			Product product = checkP.get();
			product.setName(name);
			product.setSize(size);
			product.setStatus(status);
			product.setDescription(description);
			product.setRawMaterials(rawMaterials);
			product.setCost(cost);
			product.setPrice(price);
			product.setStock(stock);
			product.setIva(iva);
			product.setUpdateDate(new Date());
			Photo photo = photoService.multiPartToEntity(file);
			product.setPhoto(photo);

			return productRepository.save(product);

		} else {
			throw new ErrorService("No se encuentra el id, para poder editar el producto");

		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Product changeStatus(String idProduct, Status status) throws ErrorService {
		Optional<Product> checkP = productRepository.findById(idProduct);
		if (checkP != null) {
			Product product = checkP.get();
			product.setStatus(status);
			if (status.equals(Status.publish)) {
				product.setPublishDate(new Date());
			}
			product.setUpdateDate(new Date());
			return productRepository.save(product);
		} else {
			throw new ErrorService("No se encuentra el id del producto, para poder publicarlo");
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
	public Product findById(String idProduct) throws ErrorService {
		Optional<Product> check = productRepository.findById(idProduct);
		Product product = check.get();
		return product;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public List<Product> findByStatus(Status status) throws ErrorService {
		return productRepository.findByStatus(status);
	}

	@Transactional(readOnly = true)
	public List<Product> findAllS() {
		return productRepository.findAllS();
	}

}
