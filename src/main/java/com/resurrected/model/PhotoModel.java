package com.resurrected.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Builder
@AllArgsConstructor
public class PhotoModel{

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
