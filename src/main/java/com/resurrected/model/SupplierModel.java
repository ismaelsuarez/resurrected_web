package com.resurrected.model;

import javax.persistence.Column;
import javax.persistence.OneToOne;

import com.resurrected.entity.Client;
import com.resurrected.entity.Photo;
import com.resurrected.enums.Example;

import lombok.Data;

@Data
public class SupplierModel {
	
	 	private String id;
	    private String enterprise;
	    
	    private Example example;

	    private Client client;
	    private String clientId;
	    private Photo photo;
	    private String photoId;
	    
}
