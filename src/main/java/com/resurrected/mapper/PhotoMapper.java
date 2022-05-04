package com.resurrected.mapper;

import com.resurrected.entity.Photo;
import com.resurrected.model.PhotoModel;
import org.springframework.stereotype.Component;

@Component
public class PhotoMapper {
    public Photo toEntity(PhotoModel model){
        return Photo.builder()
                .id(model.getId())
                .name(model.getName())
                .mime(model.getMime())
                .content(model.getContent())
                .create(model.getCreate())
                .edit(model.getEdit())
                .status(model.isStatus())
                .build();
    }
    public PhotoModel toModel(Photo photo){
        return PhotoModel.builder()
                .id(photo.getId())
                .name(photo.getName())
                .mime(photo.getMime())
                .content(photo.getContent())
                .create(photo.getCreate())
                .edit(photo.getEdit())
                .status(photo.isStatus())
                .build();
    }
}
