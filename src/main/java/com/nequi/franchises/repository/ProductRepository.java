package com.nequi.franchises.repository;

import com.nequi.franchises.repository.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProductRepository extends R2dbcRepository<ProductEntity, Long> {
}
