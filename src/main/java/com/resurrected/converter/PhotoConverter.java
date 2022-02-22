package com.resurrected.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resurrected.entity.Photo;
import com.resurrected.exception.WebException;
import com.resurrected.model.PhotoModel;
import com.resurrected.repository.PhotoRepository;

import lombok.RequiredArgsConstructor;

@Component("PhotoConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PhotoConverter extends Converter<PhotoModel, Photo> {
	
	private PhotoRepository photoRepository;
	
	@Override
	public Photo modelToEntity(PhotoModel model) throws WebException {
		
		Photo entity;
		
		if (model.getId() != null && !model.getId().isEmpty()) {
			entity = photoRepository.getOne(model.getId());
		} else {
			entity = new Photo();
		}
				
		try {
			BeanUtils.copyProperties(model, entity);
		} catch (Exception e) {
			throw new WebException("Error al convertir el modelo " + entity.toString() + " a entidad");
		}
		
		return entity;
	}

	@Override
	public PhotoModel entityToModel(Photo entity) throws WebException {

		PhotoModel model = new PhotoModel();

		try {
			BeanUtils.copyProperties(entity, model);
		} catch (Exception e) {
			throw new WebException("Error al convertir la entidad " + entity.toString() + " a modelo");
		}

		return model;
	}

	@Override
	public List<Photo> modelsToEntities(List<PhotoModel> models) throws WebException {
		
		List<Photo> entities = new ArrayList<>();

		for (PhotoModel model : models) {
			entities.add(modelToEntity(model));
		}
		
		return entities;
	}

	@Override
	public List<PhotoModel> entitiesToModels(List<Photo> entities) throws WebException {

		List<PhotoModel> models = new ArrayList<>();

		for (Photo entity : entities) {
			models.add(entityToModel(entity));
		}
		
		return models;
	}

}
