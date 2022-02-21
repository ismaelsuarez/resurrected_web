package com.resurrected.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.resurrected.enums.RawMaterials;
import com.resurrected.enums.Status;

import lombok.Data;

@Data
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

	private PhotoModel photo;
	private String photoId;
	
}
