package com.resurrected.mapper;

import com.resurrected.entity.CashRegister;
import com.resurrected.model.CashRegisterModel;
import org.springframework.stereotype.Component;

@Component
public class CashRegisterMapper {

    public CashRegister toEntity(CashRegisterModel model){
        return CashRegister.builder()
                .id(model.getId())
                .status(model.getStatus())
                .build();
    }

    public CashRegisterModel toModel(CashRegister cashRegister){
        return CashRegisterModel.builder()
                .id(cashRegister.getId())
                .status(cashRegister.getStatus())
                .build();
    }
}
