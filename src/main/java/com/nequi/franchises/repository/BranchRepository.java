package com.nequi.franchises.repository;

import com.nequi.franchises.repository.entity.BranchEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface BranchRepository extends R2dbcRepository<BranchEntity, Long> {
    Flux<BranchEntity> findByFranchiseId(Long franchiseId);
}
