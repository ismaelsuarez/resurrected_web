package com.resurrected.mapper;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.resurrected.entity.Client;
import com.resurrected.enums.Rol;
import com.resurrected.enums.StatusClient;
import com.resurrected.model.ClientRegisterModel;

@Component
public class ClientMapper {

	public ClientRegisterModel  convertToModel(String name, String lastname,String adress,String phone, String email, String password) {
		
		return new ClientRegisterModel(name, lastname,adress, phone, email, password);
	}
	
	
	public Client modelToEntity (ClientRegisterModel clientModel) {
		
		Client client = new Client();
		
		client.setName(clientModel.getName());
		client.setLastname(clientModel.getLastname());
		client.setAdress(clientModel.getAdress());
		client.setPhoneNumber(clientModel.getPhone());
		client.setEmail(clientModel.getEmail());
		String encrypted = new BCryptPasswordEncoder().encode(clientModel.getPassword());
		client.setPassword(encrypted);
		client.setCreateDate(new Date());
		client.setStatusClient(StatusClient.Base);
		client.setActive(true);
		client.setRol(Rol.CLIENT);
		
		return client;
	}
	
}
