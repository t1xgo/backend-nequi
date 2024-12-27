package com.nequi.franchises.service;

import com.nequi.franchises.controller.dto.FranchiseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseService {
    Flux<FranchiseDto> getFranchises();
    Mono<FranchiseDto> getFranchise(Long id);
    Mono<FranchiseDto> createFranchise(FranchiseDto franchiseDto);
    Mono<FranchiseDto> updateFranchise(Long id, FranchiseDto franchiseDto);
    Mono<Void> deleteFranchise(Long id);
}
