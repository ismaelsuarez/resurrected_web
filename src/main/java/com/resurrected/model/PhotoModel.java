package com.resurrected.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PhotoModel implements Serializable{
	
	private static final long serialVersionUID = 316984385362915615L;
	
	private String id;
	private String name;
	private String mime;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] content;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date edit;
	private boolean status;
	
}
