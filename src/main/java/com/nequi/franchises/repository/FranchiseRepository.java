package com.nequi.franchises.repository;

import com.nequi.franchises.repository.entity.FranchiseEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FranchiseRepository extends R2dbcRepository<FranchiseEntity, Long> {
}
