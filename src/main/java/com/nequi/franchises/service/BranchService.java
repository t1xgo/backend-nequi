package com.nequi.franchises.service;

import com.nequi.franchises.controller.dto.BranchDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchService {
    Flux<BranchDto> getBranches();
    Mono<BranchDto> getBranch(Long id);
    Mono<BranchDto> createBranch(BranchDto branchDto, Long franchiseId);
    Mono<BranchDto> updateBranch(Long id, BranchDto branchDto, Long franchiseId);
    Mono<Void> deleteBranch(Long id);
}
