package com.resurrected.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Ticket {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id_order")
	private String id;
	@Column(name = "dv_status")
	private Boolean status;
	@Column(name = "dv_delivery")
	private Boolean delivery;
	@Column(name = "dv_payment")
	private Boolean payment;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dv_load")
	private Date load;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dv_edit")
	private Date edit;

	@ManyToOne
	private Client client;

	@ManyToOne
	private CashRegister cashRegister;

	@OneToMany
	private List<Product> product;
	

}
