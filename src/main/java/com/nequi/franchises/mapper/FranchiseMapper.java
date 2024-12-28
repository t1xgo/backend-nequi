package com.nequi.franchises.mapper;

import com.nequi.franchises.controller.dto.BranchDto;
import com.nequi.franchises.controller.dto.FranchiseDto;
import com.nequi.franchises.repository.entity.FranchiseEntity;

import java.util.List;

public class FranchiseMapper {

    // Map from Entity to DTO
    public static FranchiseDto toDto(FranchiseEntity franchiseEntity, List<BranchDto> branchDtos) {
        return new FranchiseDto(
                franchiseEntity.getId(),
                franchiseEntity.getName(),
                branchDtos
        );
    }

    // Map from DTO to Entity
    public static FranchiseEntity toEntity(FranchiseDto franchiseDto) {
        return new FranchiseEntity(
                franchiseDto.id(),
                franchiseDto.name()
        );
    }
}
