package com.resurrected.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;



@Data
@Entity
public class CashRegister {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	 @Column(name = "id_cashRegister")
	private String id;
	 @Column(name = "dv_status")
	private Boolean status;
	


}
