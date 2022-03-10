package com.resurrected.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resurrected.entity.Supplier;
import com.resurrected.exception.WebException;
import com.resurrected.model.SupplierModel;

import lombok.RequiredArgsConstructor;

@Component("SupplierConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SupplierConverter extends Converter<SupplierModel, Supplier>{
	
	@Override
	public Supplier modelToEntity(SupplierModel model) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierModel entityToModel(Supplier entity) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> modelsToEntities(List<SupplierModel> models) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupplierModel> entitiesToModels(List<Supplier> entities) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

}
