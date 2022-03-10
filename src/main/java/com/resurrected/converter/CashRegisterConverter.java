package com.resurrected.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resurrected.entity.CashRegister;
import com.resurrected.exception.WebException;
import com.resurrected.model.CashRegisterModel;

import lombok.RequiredArgsConstructor;

@Component("CashRegisterConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CashRegisterConverter extends Converter<CashRegisterModel, CashRegister> {
	
	@Override
	public CashRegister modelToEntity(CashRegisterModel model) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CashRegisterModel entityToModel(CashRegister entity) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CashRegister> modelsToEntities(List<CashRegisterModel> models) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CashRegisterModel> entitiesToModels(List<CashRegister> entities) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

}
