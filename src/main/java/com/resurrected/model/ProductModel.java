package com.resurrected.model;

import java.util.Date;

import com.resurrected.entity.Photo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import com.resurrected.enums.RawMaterials;
import com.resurrected.enums.Status;

@Getter
@Builder
@AllArgsConstructor
public class ProductModel {

	private String id;
	private String name;
    private String size;
    private String category;
    private String description;	
	private Double cost;	
	private Double price;
	private Integer stock;
	private Double iva;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date publishDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	
	private RawMaterials rawMaterials;
	private Status status;

	private Photo photo;
	private String photoId;
	
}
