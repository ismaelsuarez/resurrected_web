package com.resurrected.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resurrected.entity.Client;
import com.resurrected.entity.Photo;
import com.resurrected.exception.WebException;
import com.resurrected.model.ClientModel;
import com.resurrected.model.PhotoModel;
import com.resurrected.repository.ClientRepository;
import com.resurrected.repository.PhotoRepository;

import lombok.RequiredArgsConstructor;

@Component("ClientConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ClientConverter extends Converter<ClientModel, Client>{
	
	private final ClientRepository clientRepository;
	private final PhotoRepository photoRepository;
	private final PhotoConverter photoConverter;
	
	@Override
	public Client modelToEntity(ClientModel model) throws WebException {
		
		Client entity;

		if (model.getId() != null && !model.getId().isEmpty()) {
			entity = clientRepository.getOne(model.getId());
		} else {
			entity = new Client();
		}

		try {
			Photo photoEntity = null;
			
			if(model.getPhoto() != null) {
				if(model.getPhoto().getId() != null && !model.getPhoto().getId().isEmpty()) {					
					photoEntity = photoRepository.getOne(model.getPhoto().getId());
				}
			}else if(model.getPhotoId() != null && !model.getPhotoId().isEmpty()) {
				photoEntity = photoRepository.getOne(model.getPhotoId());
			}
			
			entity.setPhoto(photoEntity);
			
			BeanUtils.copyProperties(model, entity);
		} catch (Exception e) {
			throw new WebException("Error al convertir el modelo " + entity.toString() + " a entidad");
		}
		
		return null;
	}

	@Override
	public ClientModel entityToModel(Client entity) throws WebException {

		ClientModel model = new ClientModel();

		try {
			PhotoModel photoModel = null;
			if(entity.getPhoto() != null) {
				photoModel = photoConverter.entityToModel(entity.getPhoto());
			}
			model.setPhoto(photoModel);
			model.setPhotoId(model.getPhoto().getId());
			
			BeanUtils.copyProperties(entity, model);
		} catch (Exception e) {
			throw new WebException("Error al convertir la entidad " + entity.toString() + " a modelo");
		}
		
		return null;
	}

	@Override
	public List<Client> modelsToEntities(List<ClientModel> models) throws WebException {
		
		List<Client> entities = new ArrayList<>();

		for (ClientModel model : models) {
			entities.add(modelToEntity(model));
		}

		return entities;
	}

	@Override
	public List<ClientModel> entitiesToModels(List<Client> entities) throws WebException {
		
		List<ClientModel> models = new ArrayList<>();

		for (Client entity : entities) {
			models.add(entityToModel(entity));
		}

		return models;
	}

}
