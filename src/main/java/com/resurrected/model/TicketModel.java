package com.resurrected.model;

import java.util.Date;
import java.util.List;

import com.resurrected.entity.CashRegister;
import com.resurrected.entity.Client;
import com.resurrected.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Builder
@AllArgsConstructor
public class TicketModel{

	private String id;
	private Boolean status;
	private Boolean delivery;
	private Boolean payment;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date load;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date edit;

	private Client client;
	private String clientId;

	private CashRegister cashRegister;
	private String cashRegisterId;

	private List<Product> products;
	private List<String> productsIds;

	//TODO: Cambie ClientModel -> , List<ProductModel> -> List<Product> y CashRegisterModel -> CashRegister, revisar cuando se armen mejor los endpoints!!

}
