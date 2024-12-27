package com.nequi.franchises.mapper;

import com.nequi.franchises.controller.dto.BranchDto;
import com.nequi.franchises.repository.entity.BranchEntity;

import java.util.stream.Collectors;

public class BranchMapper {

    // Map from Entity to DTO
    public static BranchDto toDto(BranchEntity branchEntity) {
        return new BranchDto(
                branchEntity.getId(),
                branchEntity.getName(),
                branchEntity.getProducts() != null
                        ? branchEntity.getProducts().stream()
                        .map(ProductMapper::toDto)
                        .collect(Collectors.toList())
                        : null
        );
    }

    // Map from DTO to Entity
    public static BranchEntity toEntity(BranchDto branchDto) {
        return BranchEntity.builder()
                .id(branchDto.id())
                .name(branchDto.name())
                .products(branchDto.products() != null
                        ? branchDto.products().stream()
                        .map(ProductMapper::toEntity)
                        .collect(Collectors.toList())
                        : null
                )
                .build();
    }
}
