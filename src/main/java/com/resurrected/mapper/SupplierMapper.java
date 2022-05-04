package com.resurrected.mapper;

import com.resurrected.entity.Supplier;
import com.resurrected.model.SupplierModel;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    public Supplier toEntity(SupplierModel model){
        return Supplier.builder()
                .id(model.getId())
                .enterprise(model.getEnterprise())
                .example(model.getExample())
                .client(model.getClient())
                .photo(model.getPhoto())
                .build();
    }

    public SupplierModel toModel(Supplier supplier){
        return SupplierModel.builder()
                .id(supplier.getId())
                .enterprise(supplier.getEnterprise())
                .example(supplier.getExample())
                .client(supplier.getClient())
                .photo(supplier.getPhoto())
                .build();
    }

}
