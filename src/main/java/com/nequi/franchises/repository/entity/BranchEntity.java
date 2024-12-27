package com.nequi.franchises.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Getter
@Setter
@Builder
@Table("branch")
public class BranchEntity {
    private Long id;
    private String name;
    private List<ProductEntity> products;
}
