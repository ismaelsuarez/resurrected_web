package com.resurrected.converter;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.resurrected.exception.WebException;


public abstract class Converter<M extends Object, E extends Object> {

	public abstract E modelToEntity(M model) throws WebException;

	public abstract M entityToModel(E entity) throws WebException;

	public abstract List<E> modelsToEntities(List<M> models) throws WebException;

	public abstract List<M> entitiesToModels(List<E> entities) throws WebException;

	protected Log log;

	public Converter() {
		this.log = LogFactory.getLog(getClass());
	}

}
