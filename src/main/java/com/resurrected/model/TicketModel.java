package com.resurrected.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TicketModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2628862223844877534L;
	private String id;
	private Boolean status;
	private Boolean delivery;
	private Boolean payment;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date load;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date edit;

	private ClientModel client;
	private String clientId;

	private CashRegisterModel cashRegister;
	private String cashRegisterId;

	private List<ProductModel> products;
	private List<String> productsIds;
	
}