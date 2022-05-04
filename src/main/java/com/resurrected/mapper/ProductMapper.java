package com.resurrected.mapper;

import com.resurrected.entity.Product;
import com.resurrected.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductModel model){
        return Product.builder()
                .id(model.getId())
                .name(model.getName())
                .status(model.getStatus())
                .size(model.getSize())
                .category(model.getCategory())
                .description(model.getDescription())
                .rawMaterials(model.getRawMaterials())
                .publishDate(model.getPublishDate())
                .createDate(model.getCreateDate())
                .updateDate(model.getUpdateDate())
                .cost(model.getCost())
                .price(model.getPrice())
                .stock(model.getStock())
                .iva(model.getIva())
                .photo(model.getPhoto())
                .build();
    }

    public ProductModel toModel(Product product){
        return ProductModel.builder()
                .id(product.getId())
                .name(product.getName())
                .status(product.getStatus())
                .size(product.getSize())
                .category(product.getCategory())
                .description(product.getDescription())
                .rawMaterials(product.getRawMaterials())
                .publishDate(product.getPublishDate())
                .createDate(product.getCreateDate())
                .updateDate(product.getUpdateDate())
                .cost(product.getCost())
                .price(product.getPrice())
                .stock(product.getStock())
                .iva(product.getIva())
                .photo(product.getPhoto())
                .build();
    }
}
