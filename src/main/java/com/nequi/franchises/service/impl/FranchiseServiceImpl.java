package com.nequi.franchises.service.impl;

import com.nequi.franchises.controller.dto.FranchiseDto;
import com.nequi.franchises.mapper.FranchiseMapper;
import com.nequi.franchises.repository.FranchiseRepository;
import com.nequi.franchises.service.FranchiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;

    @Override
    public Flux<FranchiseDto> getFranchises() {
        return franchiseRepository.findAll().map(
                        (FranchiseMapper::toDto))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<FranchiseDto> getFranchise(Long id) {
        return franchiseRepository.findById(id).map(FranchiseMapper::toDto);
    }

    @Override
    public Mono<FranchiseDto> createFranchise(FranchiseDto franchiseDto) {
        return franchiseRepository.save(FranchiseMapper.toEntity(franchiseDto)).map(FranchiseMapper::toDto);
    }

    @Override
    public Mono<FranchiseDto> updateFranchise(Long id, FranchiseDto franchiseDto) {
        return franchiseRepository.findById(id).flatMap
                (franchise -> franchiseRepository.save(FranchiseMapper.toEntity(franchiseDto)))
                .map(FranchiseMapper::toDto);
    }

    @Override
    public Mono<Void> deleteFranchise(Long id) {
        return franchiseRepository.deleteById(id);
    }
}
