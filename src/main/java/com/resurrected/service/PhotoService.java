package com.resurrected.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.resurrected.entity.Photo;
import com.resurrected.error.ErrorService;
import com.resurrected.repository.PhotoRepository;


@Service
public class PhotoService {

	@Autowired
	private PhotoRepository photoRepository;

	@Transactional
	public Photo multiPartToEntity(MultipartFile file) throws ErrorService {

		if (file != null) {
			Photo photo = new Photo();
			photo.setMime(file.getContentType());
			photo.setName(file.getName());
			try {
				photo.setContent(file.getBytes());
			} catch (IOException ex) {
				Logger.getLogger(PhotoService.class.getName()).log(Level.SEVERE, null, ex);
			}
			return photoRepository.save(photo);

		} else {

			throw new ErrorService("No se puede cargar la foto");

		}

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { ErrorService.class })
	public Photo save(Photo entity) throws Exception {
		if (entity.getCreate() != null) {
			entity.setEdit(new Date());
		} else {
			entity.setStatus(true);
			entity.setCreate(new Date());
		}

		return photoRepository.save(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { ErrorService.class })
	public Photo pasive(String id) {

		Photo entity = photoRepository.getById(id);
		entity.setStatus(false);
		return photoRepository.save(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { ErrorService.class })
	public Photo active(String id) {

		Photo entity = photoRepository.getById(id);
		entity.setStatus(true);
		return photoRepository.save(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { ErrorService.class })
	public void clear(String id) {
		Photo entity = photoRepository.getById(id);
		photoRepository.delete(entity);

	}

	@Transactional(readOnly = true)
	public List<Photo> listAll() {
		return photoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Photo> listActive() {
		return photoRepository.listTrue();
	}

	@Transactional(readOnly = true)
	public Photo getOne(String id) {
		return photoRepository.getById(id);
	}

}
