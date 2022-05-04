package com.resurrected.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CashRegisterModel {

	private String id;
	private Boolean status;

	public CashRegisterModel(String id, Boolean status) {
		this.id = id;
		this.status = status;
	}
}
