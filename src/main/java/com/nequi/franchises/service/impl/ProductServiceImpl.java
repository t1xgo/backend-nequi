package com.nequi.franchises.service.impl;

import com.nequi.franchises.controller.dto.ProductDto;
import com.nequi.franchises.mapper.ProductMapper;
import com.nequi.franchises.repository.ProductRepository;
import com.nequi.franchises.repository.entity.ProductEntity;
import com.nequi.franchises.service.ProductService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<ProductDto> getProducts() {
        return productRepository.findAll().map(ProductMapper::toDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<ProductDto> getProduct(Long id) {
        return productRepository.findById(id).map(ProductMapper::toDto);
    }

    @Override
    public Mono<ProductDto> createProduct(ProductDto productDto, Long branchId) {
        ProductEntity productEntity = ProductMapper.toEntity(productDto, branchId);
        productEntity.setBranchId(branchId);
        return productRepository.save(productEntity).map(ProductMapper::toDto);
    }

    @Override
    public Mono<ProductDto> updateProduct(Long id, ProductDto productDto, Long branchId) {
        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setName(productDto.name());
                    existingProduct.setStock(productDto.stock());
                    existingProduct.setBranchId(branchId);

                    return productRepository.save(existingProduct)
                            .map(ProductMapper::toDto);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Product not found")));
    }


    @Override
    public Mono<Void> deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }
}
