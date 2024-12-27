package com.nequi.franchises.mapper;

import com.nequi.franchises.controller.dto.FranchiseDto;
import com.nequi.franchises.repository.entity.FranchiseEntity;

import java.util.stream.Collectors;

public class FranchiseMapper {

    // Map from Entity to DTO
    public static FranchiseDto toDto(FranchiseEntity franchiseEntity) {
        return new FranchiseDto(
                franchiseEntity.getId(),
                franchiseEntity.getName(),
                franchiseEntity.getBranches() != null
                        ? franchiseEntity.getBranches().stream()
                        .map(BranchMapper::toDto)
                        .collect(Collectors.toList())
                        : null
        );
    }

    // Map from DTO to Entity
    public static FranchiseEntity toEntity(FranchiseDto franchiseDto) {
        return FranchiseEntity.builder()
                .id(franchiseDto.id())
                .name(franchiseDto.name())
                .branches(franchiseDto.branches() != null
                        ? franchiseDto.branches().stream()
                        .map(BranchMapper::toEntity)
                        .collect(Collectors.toList())
                        : null
                )
                .build();
    }
}
