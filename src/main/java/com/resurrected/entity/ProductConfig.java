package com.resurrected.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class ProductConfig {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "dv_type")
	private String type;
	@Column(name = "dv_name")
	private String name;
	@Column(name = "dv_description")
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dv_createDate")
	private Date createDate;

}
