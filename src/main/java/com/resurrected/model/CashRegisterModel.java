package com.resurrected.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CashRegisterModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -221881777840931058L;
	private String id;
	private Boolean status;
	
}
