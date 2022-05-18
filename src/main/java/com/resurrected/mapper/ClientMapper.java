package com.resurrected.mapper;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.resurrected.entity.Client;
import com.resurrected.enums.Rol;
import com.resurrected.enums.StatusClient;
import com.resurrected.model.ClientModel;
import com.resurrected.model.ClientRegisterModel;

@Component
public class ClientMapper {


	public ClientRegisterModel  convertToModel(String name, String lastname,String adress,String phone, String email, String password) {
		
		return new ClientRegisterModel(name, lastname,adress, phone, email, password);
	}

    public Client toEntity(ClientRegisterModel model){
    	
    	String encrypted = new BCryptPasswordEncoder().encode(model.getPassword());
    	
        return Client.builder()
                .name(model.getName())
                .lastname(model.getLastname())
                .phoneNumber(model.getPhone())
                .adress(model.getAdress())
                .email(model.getEmail())
                .password(encrypted)
                .createDate(new Date())
                .statusClient(StatusClient.Base)
                .active(true)
                .rol(Rol.CLIENT)
                .build();
    }

    public ClientModel toModel(Client client){
        return ClientModel.builder()
                .id(client.getId())
                .name(client.getName())
                .lastname(client.getLastname())
                .document(client.getDocument())
                .dob(client.getDob())
                .phoneNumber(client.getPhoneNumber())
                .adress(client.getAdress())
                .email(client.getEmail())
                .password(client.getPassword())
                .createDate(client.getCreateDate())
                .updateDate(client.getUpdateDate())
                .lastLogin(client.getLastLogin())
                .statusClient(client.getStatusClient())
                .active(client.getActive())
                .rol(client.getRol())
                .build();
    }
}
