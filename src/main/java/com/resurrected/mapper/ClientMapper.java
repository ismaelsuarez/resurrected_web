package com.resurrected.mapper;

import com.resurrected.entity.Client;
import com.resurrected.model.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientModel model){
        return Client.builder()
                .id(model.getId())
                .name(model.getName())
                .lastname(model.getLastname())
                .document(model.getDocument())
                .dob(model.getDob())
                .phoneNumber(model.getPhoneNumber())
                .adress(model.getAdress())
                .email(model.getEmail())
                .password(model.getPassword())
                .createDate(model.getCreateDate())
                .updateDate(model.getUpdateDate())
                .lastLogin(model.getLastLogin())
                .statusClient(model.getStatusClient())
                .active(model.getActive())
                .rol(model.getRol())
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
