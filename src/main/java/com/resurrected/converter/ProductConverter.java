package com.resurrected.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resurrected.entity.Product;
import com.resurrected.exception.WebException;
import com.resurrected.model.ProductModel;

import lombok.RequiredArgsConstructor;

@Component("ProductConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductConverter extends Converter<ProductModel, Product>{
	
	@Override
	public Product modelToEntity(ProductModel model) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel entityToModel(Product entity) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> modelsToEntities(List<ProductModel> models) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> entitiesToModels(List<Product> entities) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

}
