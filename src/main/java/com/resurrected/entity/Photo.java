package com.resurrected.entity;


import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Photo {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id_photo")
	private String id;
	@Column(name = "dev_name")
	private String name;
	@Column(name = "dev_mime")
	private String mime;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "dv_content")
	private byte[] content;

	@Temporal(TemporalType.DATE)
	@Column(name = "dv_create")
	private Date create;

	@Temporal(TemporalType.DATE)
	@Column(name = "dv_edit")
	private Date edit;
	@Column(name = "dv_status")
	private boolean status;

	
	
}