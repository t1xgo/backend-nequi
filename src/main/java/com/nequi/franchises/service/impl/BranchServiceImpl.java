package com.nequi.franchises.service.impl;

import com.nequi.franchises.controller.dto.BranchDto;
import com.nequi.franchises.mapper.BranchMapper;
import com.nequi.franchises.repository.BranchRepository;
import com.nequi.franchises.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    @Override
    public Flux<BranchDto> getBranches() {
        return branchRepository.findAll().map(BranchMapper::toDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<BranchDto> getBranch(Long id) {
        return branchRepository.findById(id).map(BranchMapper::toDto);
    }

    @Override
    public Mono<BranchDto> createBranch(BranchDto branchDto) {
        return branchRepository.save(BranchMapper.toEntity(branchDto)).map(BranchMapper::toDto);
    }

    @Override
    public Mono<BranchDto> updateBranch(Long id, BranchDto branchDto) {
        return branchRepository.findById(id).flatMap
                (branch -> branchRepository.save(BranchMapper.toEntity(branchDto)))
                .map(BranchMapper::toDto);
    }

    @Override
    public Mono<Void> deleteBranch(Long id) {
        return branchRepository.deleteById(id);
    }
}
