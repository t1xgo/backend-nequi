package com.nequi.franchises.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table("product")
public class ProductEntity {
    private Long id;
    private String name;
    private Integer stock;
}
