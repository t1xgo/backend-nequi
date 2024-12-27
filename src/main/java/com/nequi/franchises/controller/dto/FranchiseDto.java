package com.nequi.franchises.controller.dto;

import java.util.List;

public record FranchiseDto(Long id, String name, List<BranchDto> branches) {
}
