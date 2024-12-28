package com.nequi.franchises.service.impl;

import com.nequi.franchises.controller.dto.BranchDto;
import com.nequi.franchises.controller.dto.ProductDto;
import com.nequi.franchises.mapper.BranchMapper;
import com.nequi.franchises.mapper.ProductMapper;
import com.nequi.franchises.repository.BranchRepository;
import com.nequi.franchises.repository.ProductRepository;
import com.nequi.franchises.service.BranchService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final ProductRepository productRepository;

    public BranchServiceImpl(BranchRepository branchRepository, ProductRepository productRepository) {
        this.branchRepository = branchRepository;
        this.productRepository = productRepository;
    }

    private Mono<List<ProductDto>> getProductsByBranchId(Long branchId) {
        return productRepository.findByBranchId(branchId)
                .map(ProductMapper::toDto)
                .collectList();
    }

    @Override
    public Flux<BranchDto> getBranches() {
        return branchRepository.findAll().flatMap(branchEntity ->
                getProductsByBranchId(branchEntity.getId())
                        .map(productDtos -> BranchMapper.toDto(branchEntity, productDtos))
        );
    }

    @Override
    public Mono<BranchDto> getBranch(Long id) {
        return branchRepository.findById(id).flatMap(branchEntity ->
                getProductsByBranchId(branchEntity.getId())
                        .map(productDtos -> BranchMapper.toDto(branchEntity, productDtos))
        );
    }

    @Override
    public Mono<BranchDto> createBranch(BranchDto branchDto, Long franchiseId) {
        return branchRepository.save(BranchMapper.toEntity(branchDto, franchiseId)).flatMap(branchEntity ->
                getProductsByBranchId(branchEntity.getId())
                        .map(productDtos -> BranchMapper.toDto(branchEntity, productDtos))
        );
    }

    @Override
    public Mono<BranchDto> updateBranch(Long id, BranchDto branchDto, Long franchiseId) {
        return branchRepository.findById(id).flatMap
                (branch -> branchRepository.save(BranchMapper.toEntity(branchDto, franchiseId)))
                .flatMap(branchEntity ->
                        getProductsByBranchId(branchEntity.getId())
                                .map(productDtos -> BranchMapper.toDto(branchEntity, productDtos))
                );
    }

    @Override
    public Mono<Void> deleteBranch(Long id) {
        return branchRepository.deleteById(id);
    }
}
