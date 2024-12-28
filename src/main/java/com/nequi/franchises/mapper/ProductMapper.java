package com.nequi.franchises.mapper;

import com.nequi.franchises.controller.dto.ProductDto;
import com.nequi.franchises.repository.entity.ProductEntity;

public class ProductMapper {

    // Mapping from entity to Dto
    public static ProductDto toDto(ProductEntity productEntity) {
        return new ProductDto(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getStock()
        );
    }

    // Mapping from Dto to entity
    public static ProductEntity toEntity(ProductDto productDto, Long branchId) {
        return new ProductEntity(
                productDto.id(),
                productDto.name(),
                productDto.stock(),
                branchId
        );
    }
}
