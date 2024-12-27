package com.nequi.franchises.service.impl;

import com.nequi.franchises.controller.dto.ProductDto;
import com.nequi.franchises.mapper.ProductMapper;
import com.nequi.franchises.repository.ProductRepository;
import com.nequi.franchises.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
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
    public Mono<ProductDto> createProduct(ProductDto productDto) {
        return productRepository.save(ProductMapper.toEntity(productDto)).map(ProductMapper::toDto);
    }

    @Override
    public Mono<ProductDto> updateProduct(Long id, ProductDto productDto) {
        return productRepository.findById(id).flatMap
                (product -> productRepository.save(ProductMapper.toEntity(productDto)))
                .map(ProductMapper::toDto);
    }

    @Override
    public Mono<Void> deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }
}
