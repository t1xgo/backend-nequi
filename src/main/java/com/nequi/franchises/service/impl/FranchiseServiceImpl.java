package com.nequi.franchises.service.impl;

import com.nequi.franchises.controller.dto.BranchDto;
import com.nequi.franchises.controller.dto.FranchiseDto;
import com.nequi.franchises.mapper.BranchMapper;
import com.nequi.franchises.mapper.FranchiseMapper;
import com.nequi.franchises.mapper.ProductMapper;
import com.nequi.franchises.repository.BranchRepository;
import com.nequi.franchises.repository.FranchiseRepository;
import com.nequi.franchises.repository.ProductRepository;
import com.nequi.franchises.repository.entity.FranchiseEntity;
import com.nequi.franchises.service.FranchiseService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;
    private final BranchRepository branchRepository;
    private final ProductRepository productRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, BranchRepository branchRepository, ProductRepository productRepository) {
        this.franchiseRepository = franchiseRepository;
        this.branchRepository = branchRepository;
        this.productRepository = productRepository;
    }

    private Mono<List<BranchDto>> getBranchesByFranchiseId(Long franchiseId) {
        return branchRepository.findByFranchiseId(franchiseId)
                .flatMap(branchEntity ->
                        productRepository.findByBranchId(branchEntity.getId())
                                .map(ProductMapper::toDto)
                                .collectList()
                                .map(productDtos -> BranchMapper.toDto(branchEntity, productDtos))
                )
                .collectList();
    }

    @Override
    public Flux<FranchiseDto> getFranchises() {
        return franchiseRepository.findAll()
                .flatMap(franchiseEntity ->
                        getBranchesByFranchiseId(franchiseEntity.getId())
                                .map(branchDtos -> FranchiseMapper.toDto(franchiseEntity, branchDtos))
                );
    }

    @Override
    public Mono<FranchiseDto> getFranchise(Long id) {
        return franchiseRepository.findById(id)
                .flatMap(franchiseEntity ->
                        getBranchesByFranchiseId(franchiseEntity.getId())
                                .map(branchDtos -> FranchiseMapper.toDto(franchiseEntity, branchDtos))
                );
    }

    @Override
    public Mono<FranchiseDto> createFranchise(FranchiseDto franchiseDto) {
        return franchiseRepository.save(FranchiseMapper.toEntity(franchiseDto))
                .flatMap(franchiseEntity ->
                        getBranchesByFranchiseId(franchiseEntity.getId())
                                .map(branchDtos -> FranchiseMapper.toDto(franchiseEntity, branchDtos))
                );
    }

    @Override
    public Mono<FranchiseDto> updateFranchise(Long id, FranchiseDto franchiseDto) {
        return franchiseRepository.findById(id)
                .flatMap(existingFranchise -> convertAndSaveFranchise(id, franchiseDto));
    }

    private Mono<FranchiseDto> convertAndSaveFranchise(Long id, FranchiseDto franchiseDto) {
        FranchiseEntity franchiseEntity = FranchiseMapper.toEntity(franchiseDto);
        franchiseEntity.setId(id);
        return franchiseRepository.save(franchiseEntity)
                .flatMap(savedFranchise ->
                        getBranchesByFranchiseId(savedFranchise.getId())
                                .map(branchDtos -> FranchiseMapper.toDto(savedFranchise, branchDtos))
                );
    }

    @Override
    public Mono<Void> deleteFranchise(Long id) {
        return franchiseRepository.deleteById(id);
    }
}
