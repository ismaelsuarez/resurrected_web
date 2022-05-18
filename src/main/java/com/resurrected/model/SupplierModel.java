package com.resurrected.model;

import java.io.Serializable;



import com.resurrected.entity.Client;
import com.resurrected.entity.Photo;
import com.resurrected.enums.Example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SupplierModel implements Serializable{

		private String id;
	    private String enterprise;
	    
	    private Example example;

	    private Client client;
	    private String clientId;
	    private Photo photo;
	    private String photoId;
	    
}
