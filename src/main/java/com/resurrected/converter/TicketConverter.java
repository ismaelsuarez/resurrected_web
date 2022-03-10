package com.resurrected.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resurrected.entity.Ticket;
import com.resurrected.exception.WebException;
import com.resurrected.model.TicketModel;

import lombok.RequiredArgsConstructor;

@Component("TicketConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TicketConverter extends Converter<TicketModel, Ticket>{
	
	@Override
	public Ticket modelToEntity(TicketModel model) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketModel entityToModel(Ticket entity) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> modelsToEntities(List<TicketModel> models) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TicketModel> entitiesToModels(List<Ticket> entities) throws WebException {
		// TODO Auto-generated method stub
		return null;
	}

}
