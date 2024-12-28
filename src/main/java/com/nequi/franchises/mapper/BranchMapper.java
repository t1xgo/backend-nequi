package com.nequi.franchises.mapper;

import com.nequi.franchises.controller.dto.BranchDto;
import com.nequi.franchises.controller.dto.ProductDto;
import com.nequi.franchises.repository.entity.BranchEntity;

import java.util.List;

public class BranchMapper {

    // Map from Entity to DTO
    public static BranchDto toDto(BranchEntity branchEntity, List<ProductDto> productDtos) {
        return new BranchDto(
                branchEntity.getId(),
                branchEntity.getName(),
                productDtos
        );
    }

    // Map from DTO to Entity
    public static BranchEntity toEntity(BranchDto branchDto, Long franchiseId) {
        return new BranchEntity(
                branchDto.id(),
                branchDto.name(),
                franchiseId
        );
    }
}
