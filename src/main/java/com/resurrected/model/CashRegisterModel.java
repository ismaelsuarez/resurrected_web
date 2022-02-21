package com.resurrected.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CashRegisterModel {
	
	private String id;
	private Boolean status;
	
}
