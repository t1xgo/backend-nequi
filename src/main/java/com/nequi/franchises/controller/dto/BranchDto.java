package com.nequi.franchises.controller.dto;

import java.util.List;
import com.nequi.franchises.controller.dto.ProductDto;

public record BranchDto(Long id, String name, List<ProductDto> products) {
}
